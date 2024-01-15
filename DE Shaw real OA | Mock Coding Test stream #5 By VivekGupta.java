Given an array with size N. Find the number of subsets with a sum divisible by 7. The answer can be too large , print it with modulo 10^9+7.

Input Format :
The first line of input contains a single integer T, denoting number of test cases. Next, the test cases follow.Description of each test case:
The first line contains a sinle integer N, denoting size of array.
The second line contains N space separeted integer A1,A2,A3.....An, denoting the array.

Output Format :
Print T lines each containing a single integer, denoting the number of subsets with a sum divisible by 7 modulo 10^9+7.

Constraints :
1<=T<=10^5
1<=N<=10^5
1<=Ni<=10^9
1<=SUM OF ALL N<=10^6
All values of position are unique

code :
import java.util.*;
public class OA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[]={1,2,3,4,5,6};
        System.out.println(subsetSumDivBy7(a));
    }
    static int subsetSumDivBy7(int a[]){
        int n=a.length;
        int ans=0;
        Map<Integer,Integer>num_frq=new HashMap<>();
        long cur_sum=0;
        for(int i=0;i<n;i++){
            cur_sum+=a[i];
            int mod=(int)(cur_sum%7);
            if(num_frq.containsKey(mod)) {
                ans += num_frq.get(mod);
                num_frq.put(mod,num_frq.get(mod)+1);
            }else num_frq.put(mod,1);
        }
        return ans;
    }
}
