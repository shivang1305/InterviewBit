/* BINARY SEARCH - SIMPLE                                                        Date: 28-May-2021
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Example 1:
Input: x = 2.00000, n = 10
Output: 1024.00000

Example 2:
Input: x = 2.10000, n = 3
Output: 9.26100

Example 3:
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
*/

public class power_function {
    public double myPow(double x, int n) {
        // return Math.pow(x, n); // naive approach
        
        // BRUTE FORCE APPROACH - TLE
        double ans = 1;
        if(n < 0) {
            double m = n * -1;
            for(double i = 1; i <= m; i++)
                ans *= x;
            ans = 1 / ans;
        }
        else {
            for(double i = 1; i <= n; i++)
                ans *= x; 
        }
        
        return ans;  // Time complexity = O(N)
    }

    public double pow2(double x, int n) {
        // OPTIMAL SOLUTION - Binary Search (divide and conquer approach)
        double ans = 1.0;
        long nn = n;
        
        if(n < 0)
            nn = nn * -1;
        
        while(nn > 0) {
            if(nn % 2 == 0) {
                x *= x;
                nn /= 2;
            }
            else {
                ans *= x;
                nn -= 1;
            }
        }
        
        if(n < 0)
            ans = (double)1 / (double)ans;
        
        return ans; // Time Complexity = O(1)
    }
}
