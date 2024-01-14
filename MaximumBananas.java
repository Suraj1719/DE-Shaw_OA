Question : https://www.geeksforgeeks.org/de-shaw-on-campus-interview-experience-qa-engineer/

There are three buildings in a row named A, B and C. Each building contains N floors. Each of the floors in each of the building contains a certain number of bananas. 
You can collect all the bananas at each floor as you make your way up from the ground floor to the Nth floor of a building. You can also jump from the ith floor of a
building to the (i+1)th floor of its adjacent buildings. But you can only do so K times as you make your way up to the top. 
Given are 3 arrays A[], B[] and C[] each of size N. The number of bananas at the ith floor of each building is indicated by 
the respective arr[i] ( A[i] for building A, B[i] for building B and C[i] for building C). The maximum number of jumps that can be made is given as K. 
Find the maximum number of bananas that can be collected starting from the ground floor to the Nth floor with no more than K jumps.

Input : A[] = {4, 5, 1, 2, 10}, B[] = {9, 7, 3, 20, 16}, C[] = {6, 12, 13, 9, 8}, K=2 

Output : 70 

Explanation: 

Start from building B. Collect the 9 bananas in the first floor. 
Jump to building C. Collect the 12 bananas from the second and 13 bananas from third floor. ( Jump 1 ) 
Jump back to building B. Collect the 20 bananas from fourth floor and 16 bananas in fifth floor. ( Jump 2 ) 

Number of jumps made = 2 
Number of bananas collected= 9+12+13+20+16=70 bananas


  code : Brute Force

  import java.util.*;
public class OA {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //int k=sc.nextInt();
         int a[]={4, 5, 1, 2, 10};
         int b[]={9, 7, 3, 20, 16};
         int c[]={6, 12, 13, 9, 8};
        int list[][]=new int[a.length][3];
        for(int i=0;i<a.length;i++){
            list[i][0]=a[i];
            list[i][1]=b[i];
            list[i][2]=c[i];
        }

        int k=2;
        int ans=0;

        ans=Math.max(ans,solve(0,0,k,list));
        //System.out.println(ans);
        ans=Math.max(ans,solve(1,0,k,list));
        //System.out.println(ans);
        ans=Math.max(ans,solve(2,0,k,list));

        System.out.println("Ans ="+ans);
    }

    static int solve(int col,int ind,int k,int list[][]){
        int max=0;
        int cur=0;
        for(int i=ind;i<list.length;i++){
            cur+=list[i][col];
            //System.out.println("cur "+cur);
            if(k>0){
                int not_change=cur+solve(col,i+1,k,list);
                int change=0;
                if(col!=0){
                    change=Math.max(change,cur+solve(0,i+1,k-1,list));
                }
                if(col!=1){
                    change=Math.max(change,cur+solve(1,i+1,k-1,list));
                }
                if(col!=2){
                    change=Math.max(change,cur+solve(2,i+1,k-1,list));
                }
                max=Math.max(max,Math.max(not_change,change));
            }
            max=Math.max(max,cur);

        }
        return max;
    }
  }
