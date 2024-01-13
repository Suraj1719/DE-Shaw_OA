https://docs.google.com/document/d/1ddCV9pTFFkvJRascZEU_Nckh3-nzLDet0Hj77KR6s4o/edit

Que : https://www.desiqna.in/16043/shaw-coding-question-solution-sde1-september-2023-subarrays

Constrain : 1<=n<=2*10^5


  This approach takes
  Time :O(n)=space


  Here we want to minimize p2,p4 to maximize purpose of g=p1+p3-(p2+p4)
JAVA CODE:

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long n = sc.nextLong();
        long[] b = new long[(int)(n+1)];
        long tot = 0;
        long i = 1;
        
        while (i <= n) {
            b[(int)i] = sc.nextLong();
            tot += b[(int)i];
            i++;
        }
        
        long[] p = new long[(int)(n+5)];
        i = 1;
        
        while (i <= n) {
            p[(int)i] = Math.min(b[(int)i], b[(int)i] + p[(int)i - 1]);
            i++;
        }
        
        long[] s = new long[(int)(n+5)];
        i = n;
        long sum = 0;
        
        while (i >= 1) {
            sum = sum + b[(int)i];
            s[(int)i] = Math.min(sum, s[(int)i + 1]);
            i--;
        }
        
        i = 0;
        long t = 0;
        long d = (long)1e18;
        
        while (i <= n) {
            long v = Math.min(t, p[(int)i]) + Math.min(s[(int)(i+1)], t);
            d = Math.min(d, v);
            i++;
        }
        
        System.out.println(tot - 2 * d);
        sc.close();
    }
}


c++ code :
#include <bits/stdc++.h>

using namespace std;
typedef long long int ll ; 
int main() {
    
    ll n;
    cin>>n;
    ll b[n+1]={0};
    ll tot = 0 ; 
    ll i = 1 ; 
    while(i<=n){
        cin>>b[i];
        tot+=b[i];
        i++;
    }
    
    ll p[n+5]={0};
    
    i = 1 ; 
    while(i<=n){
        
        p[i] = min(b[i],b[i]+p[i-1]);
        
        i++;
    }
    
    ll s[n+5]={0};
    i = n ; ll sum = 0 ; 
    while(i>=1){
        sum = sum + b[i];
        s[i] = min(sum,s[i+1]);
        i--;
    }
    
    i = 0 ;
    ll t = 0 ; ll d = 1e18;
    while(i<=n){
        
        ll v = min(t,p[i]) + min(s[i+1],t);
        d = min(d,v);
        
        i++;
    }
    cout<<tot-2*d;
    //cout<<d;
    
    return 0 ;
    
}


python code :

  def main():
    n = int(input())
    b = [0] * (n + 1)
    tot = 0
    i = 1

    while i <= n:
        b[i] = int(input())
        tot += b[i]
        i += 1

    p = [0] * (n + 5)
    i = 1

    while i <= n:
        p[i] = min(b[i], b[i] + p[i - 1])
        i += 1

    s = [0] * (n + 5)
    i = n
    sum_val = 0

    while i >= 1:
        sum_val = sum_val + b[i]
        s[i] = min(sum_val, s[i + 1])
        i -= 1

    i = 0
    t = 0
    d = 1e18

    while i <= n:
        v = min(t, p[i]) + min(s[i + 1], t)
        d = min(d, v)
        i += 1

    print(tot - 2 * d)

if __name__ == "__main__":
    main()


