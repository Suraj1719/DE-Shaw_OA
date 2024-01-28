YT: https://www.youtube.com/watch?v=2OzV0M0Qf9I
Question: https://www.desiqna.in/16089/atlassian-oa-sde1-ctc-75-lac

Note : Find the pdf in this repo


import java.util.*;
public class OA {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String []s={"ab",
                "bab"};
        System.out.println("Answer is =");
        System.out.println(AtlassianSuperHardOA(s));
    }

  
    public static int AtlassianSuperHardOA(String[] a){
        int frq[]=new int[26];
        //we try to make palindromic string of small length first , so we need min heap
        PriorityQueue<Integer>string_len=new PriorityQueue<>();
        for(int i=0;i<a.length;i++){
            String cur=a[i];
            string_len.add(cur.length());
            for(int j=0;j<cur.length();j++){
                frq[cur.charAt(j)-'a']++;
            }
        }

        //store frequencies of character in max heap of even and odd
        PriorityQueue<Integer>even_char_frq=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer>odd_char_frq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<26;i++){
            if(frq[i]!=0){
                //System.out.println(frq[i]);
                if(frq[i]%2==0)even_char_frq.add(frq[i]);
                else odd_char_frq.add(frq[i]);
            }
        }
        int ans=0;
        while(!string_len.isEmpty()) {
            int cur_len = string_len.peek();
            //System.out.println("current string length = "+cur_len);
            string_len.poll();
            if (cur_len % 2 == 0) {

                while (cur_len != 0 && !even_char_frq.isEmpty()) {
                    int top_char_frq = even_char_frq.peek();
                    //System.out.println(top_char_frq);
                    if (top_char_frq <= cur_len) {
                        cur_len = cur_len - top_char_frq;
                        even_char_frq.poll();
                    } else {
                        top_char_frq = top_char_frq - cur_len;
                        cur_len = 0;
                        even_char_frq.poll();
                        even_char_frq.add(top_char_frq);
                    }
                }

                //System.out.println("Rem "+cur_len);
                while (cur_len != 0 && !odd_char_frq.isEmpty()) {
                    int top_char_frq = odd_char_frq.peek() - 1;
                    if(top_char_frq==0)break;
                    if (top_char_frq <= cur_len) {
                        cur_len = cur_len - top_char_frq;
                        odd_char_frq.poll();
                        odd_char_frq.add(1);
                    } else {
                        top_char_frq = top_char_frq - cur_len;
                        cur_len = 0;
                        odd_char_frq.poll();
                        odd_char_frq.add(top_char_frq);
                    }
                }
            }else{
                while (cur_len != 1 && !even_char_frq.isEmpty()) {//ignore middle character and try to use same method used for even length
                    int top_char_frq = even_char_frq.peek();
                    if (top_char_frq <= cur_len-1) {
                        cur_len = cur_len - top_char_frq;
                        even_char_frq.poll();
                    } else {
                        top_char_frq = top_char_frq - cur_len+1;
                        cur_len = 1;
                        even_char_frq.poll();
                        even_char_frq.add(top_char_frq);
                    }
                }
                //System.out.println("Rem ="+cur_len);
                while (cur_len != 0 && !odd_char_frq.isEmpty()) {
                    int top_char_frq = odd_char_frq.peek() - 1;
                    if(cur_len==1 && top_char_frq==0){
                        cur_len=0;
                        odd_char_frq.poll();
                        break;
                    }
                    if (top_char_frq <= cur_len) {
                        cur_len = cur_len - top_char_frq;
                        odd_char_frq.poll();
                        odd_char_frq.add(1);
                    } else {
                        top_char_frq = top_char_frq - cur_len;
                        cur_len = 0;
                        odd_char_frq.poll();
                        odd_char_frq.add(top_char_frq);
                    }
                }
            }

            if(cur_len==0)ans++;
            else break;
        }

        return ans;
    }
