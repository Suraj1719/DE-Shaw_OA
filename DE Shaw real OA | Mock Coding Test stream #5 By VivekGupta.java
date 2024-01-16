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

This is for subArray.
    
import java.util.*;
public class OA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[]={1,2,3,4,5,6};
        System.out.println(subsetSumDivBy7(a));
    }
    static int subArraySumDivBy7(int a[]){
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

For Subsets :   link : https://iq.opengenus.org/find-number-of-subsets-with-sum-divisible-by-m/

Naive Approach : 
In naive approach we find all the subsets of the given array by recursion and find sum of all possible subsets and count how many sum values are divisible by m.
If the sum of any two subsets is same we have to count the frequency of such a value and add it to the answer.

The time complexity of such a technique is O(2^length) where length signifies the length of the given array.

Using DP: 
Basic Idea
We first find the total sum of all the array elements,the sum of any subset will be less than or equal to that value. So we make an array DP[sum+2][length+2] as
in the 0th row we will fill the possible sum values and in the 0th column we will fill the array values and initialize it with value'0'.
We fill the column-'1' of all the rows with value 1 as there is always a subset with sum value='0' and then for each array element 
we find if the above row has that particular sum value not equal to zero we add that element to that sum and in the cell of the resultant sum 
we update it's valued by the sum of its previous frequency and frequency value of the particluar sum value.

Intuitive idea
For a particular array element i if DP[i-1][j] is not equal to zero the then we update the value of DP[i][j+arr[i]] by sum of DP[i-1][j+arr[i]] and DP[i-1][j].
At last we check in the last row and if column number is divisible by m then add that value to ans.

Example:
A={1,2,2}
m=2
Subsets are-{2},{2},{2,2},{}
Subset count is 4


Java code :
    private static void subSetSumDivBy7(int[] a) {
        int sum=0;
        int n=a.length;
        for(int i=0;i<a.length;i++)
        {
            sum+=a[i];
        }
        long dp[][]=new long[n+2][sum+2];
        for(int i=0;i<n+2;i++)
        {
            Arrays.fill(dp[i],0);
        }
        //Filling 0th row of the table With all possible sum values
        for(int j=1;j<sum+2;j++)
        {
            dp[0][j]=j-1;
        }

        //Filling 0th column With all the array values
        dp[1][0]=0;
        for(int j=2;j<n+2;j++)
        {
            dp[j][0]=a[j-2];
        }

        //Filling 1st column Where sum value=0 with all 1's
        for(int i=1;i<n+2;i++)
        {
            dp[i][1]=1;
        }

        //Filling the DP table according to given logic
        for(int i=2;i<n+2;i++)
        {
            for(int j=1;j<sum+2;j++)
            {
                if(dp[i-1][j]!=0)
                {
                    dp[i][j+a[i-2]]=dp[i-1][j+a[i-2]]+dp[i-1][j];
                }
            }
            for(int j=1;j<sum+2;j++)
            {
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j]);
            }
        }
        //counting the number of values divisible by m
        for(int j=1;j<sum+2;j++)
        {
            if((j)%7==0)
                ans+=dp[n+1][j];

        }

    }
C++ code :
#include<bits/stdc++.h>
   using namespace std;
   #define ll long long int
   int main()
   {
    ll arr[]={2,3,3,1};
    ll l=4;
    ll m=6;
    ll i,j,sum=0,ans=0;
 

    //Calculating the maximum possible sum
    for(i=0;i<l;i++)
    {
     sum+=arr[i];
    }

    ll DP[l+2][sum+2];
    for(i=0;i<l+2;i++)
    {
      for(j=0;j<sum+2;j++)
      {
      DP[i][j]=0;
      }
     }
 

    //Filling 0th row of the table
    //With all possible sum values
    for(j=1;j<sum+2;j++)
    {
     DP[0][j]=j-1;
    }

    //Filling 0th column 
    //With all the array values
   DP[1][0]=0;
   for(j=2;j<l+2;j++)
   {
   DP[j][0]=arr[j-2];
   }

   //Filling 1st column 
   //Where sum value=0 with all 1's
   for(i=1;i<l+2;i++)
   {
   DP[i][1]=1;
   } 
 

   //Filling the DP table
   //according to given logic
   for(i=2;i<l+2;i++)
   {
     for(j=1;j<sum+2;j++)
     {      
      if(DP[i-1][j]!=0)
      {
       DP[i][j+arr[i-2]]=DP[i-1][j+arr[i-2]]+DP[i-1][j];
      }
     }
     for(j=1;j<sum+2;j++)
     {
      DP[i][j]=max(DP[i-1][j],DP[i][j]); 
     }  
    }
 

   //counting the number of values
   //divisible by m
   for(j=1;j<sum+2;j++)
   {
    if((j-1)%m==0)
    ans+=DP[l+1][j];
  
   }
   cout<<"Number of subsets is:"<<ans<<"\n";
   return 0;
   }
