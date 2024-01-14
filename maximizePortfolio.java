YT SOL: https://www.youtube.com/watch?v=a9OkuUehrF0&list=PLIp-xrYmLruIMeobYXCGv4Dgtwds0nw7_&index=9

question : https://www.desiqna.in/9717/de-shaw-oa-sde-set-55-kumar-k

constrain : 1<n<=2*10^5


  
Approach - 1( time :O(n * total_sum)  gives tle )
  import java.util.*;
public class OA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k=sc.nextInt();
        int n = sc.nextInt();
        int array[] = new int[n];
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        System.out.println(de_shaw_oa(array, k));
    }

    static int de_shaw_oa(int a[],int k){
        long sum=0;
        for(int x:a)sum+=x;
        //now at max we can make sum number of portfolios and minimum 0 number of portfolio
        int ans=0;
        for(int portfolio=0;portfolio<=sum;portfolio++){
            if(isPossible(portfolio,k,a)==true)
                ans=portfolio;
            else break;
        }
        return ans;

    }

    private static boolean isPossible(int portfolio, int k, int[] a) {
        long req_stoks=k*portfolio*1l;
        long cur_stoke_we_can_used=0;
        int ind=0;
        while(ind<a.length){
            if(a[ind]>portfolio){
                req_stoks-=portfolio;
            }else req_stoks-=a[ind];

            ind++;
        }
        //System.out.println(req_stoks+" "+cur_stoke_we_can_used);
        if(req_stoks<=0)return true;

        return false;

    }
}

Approach - 2 (optimisation: Binary Search)
  time :O(n log(toyal_sum)) space:O(1)
  
import java.util.*;
public class OA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //int k=sc.nextInt();
        int n = sc.nextInt();
        int k=sc.nextInt();
        int array[] = new int[n];
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        System.out.println(de_shaw_oa(array, k));
    }

    static int de_shaw_oa(int a[],int k){
        long sum=0;
        for(int x:a)sum+=x;
        //now at max we can make sum number of portfolios and minimum 0 number of portfolio
        int ans=0;
        int min_port=0;
        int max_port=(int)sum;
        while(min_port<=max_port){
            int mid=min_port+(max_port-min_port)/2;
            if(isPossible(mid,k,a)==true){
                ans=mid;
                min_port=mid+1;
            }else max_port=mid-1;
        }

        return ans;

    }

    private static boolean isPossible(int portfolio, int k, int[] a) {
        long req_stoks=k*portfolio*1l;
        long cur_stoke_we_can_used=0;
        int ind=0;
        while(ind<a.length){
            if(a[ind]>portfolio){
                req_stoks-=portfolio;
            }else req_stoks-=a[ind];

            ind++;
        }
        //System.out.println(req_stoks+" "+cur_stoke_we_can_used);
        if(req_stoks<=0)return true;

        return false;

    }

