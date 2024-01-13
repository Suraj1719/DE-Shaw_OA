Q: https://www.desiqna.in/14025/de-shaw-coding-oa-solution-july-2023-sde1-38-lac-ctc 

Given an array arr of size n which contain all integer from 1 to n,and an integer k. Find the kth smallest MEX of a subarray of the array.
That is the list containing all MEX, return the kth smallest MEX.

The MEX of an array is the smallest positive number not present in the array. For Example [1,2,3] is 4 and [1,3,4] is 2.


Input 1:
n=4
arr=[3,2,1,4]
k=5


code : using hashmap
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] b = new long[n + 1];
        Map<Long, Long> kk = new HashMap<>();
        int i = 1;
        while (i <= n) {
            b[i] = scanner.nextLong();
            kk.put(b[i], (long) i);
            i++;
        }
        long k = scanner.nextLong();
        long[] answer = new long[n + 5];
        long left = kk.get(1L);
        long right = kk.get(1L);
        long n1 = left - 1;
        long n2 = n - right;
        answer[1] = (n1 * (n1 + 1) / 2) + (n2 * (n2 + 1) / 2);
        i = 2;
        while (i <= n) {
            long id = kk.get((long) i);
            if (left > id && right > id) {
                long x = left - id - 1;
                long y = n - right;
                answer[i] = (x + 1) * (y + 1);
            } else if (left < id && right < id) {
                long x = left - 1;
                long y = id - right - 1;
                answer[i] = (x + 1) * (y + 1);
            } else {
                // Handle other cases if needed
            }
            left = Math.min(left, id);
            right = Math.max(right, id);
            i++;
        }
        answer[n + 1] = 1;
        long c = 0;
        long topG = 0;
        i = 1;
        while (i <= n + 1) {
            c += answer[i];
            if (c < k) {
                // Do nothing
            } else {
                topG = i;
                i = n + 5;
                break;
            }
            i++;
        }
        System.out.println(topG);
        scanner.close();
    }
}
