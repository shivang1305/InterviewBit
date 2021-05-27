/* MATHS - COMBINATORICS                                                            Date: 25-May-2021
A robot is located at the top-left corner of an A x B grid (marked ‘Start’ in the diagram below).

Path Sum: Example 1

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).

How many possible unique paths are there?

Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.

Example :

Input : A = 2, B = 2
Output : 2

2 possible routes : (0, 0) -> (0, 1) -> (1, 1) 
              OR  : (0, 0) -> (1, 0) -> (1, 1)
*/

public class grid_unique_paths {
    public int uniquePaths(int m, int n) {
        // int[][] dp = new int[m + 1][n + 1];
        // for(int i = 0; i < dp.length; i++) {
        //     for(int j = 0; j < dp[0].length; j++)
        //         dp[i][j] = -1;
        // }
        // return solMemo(1, 1, m, n, dp);
        return solTabu(m, n);
    }

    
    public int solMemo(int i, int j, int m, int n, int[][] dp) {
        if(i == m && j == n)
            return dp[i][j] = 1;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int hPaths = 0, vPaths = 0;
        if(j < n)
            hPaths = solMemo(i, j + 1, m, n, dp);
        if(i < m)
            vPaths = solMemo(i + 1, j, m, n, dp);
        
        return dp[i][j] = hPaths + vPaths;
    }
    
    public int solTabu(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m - 1 && j == n - 1)
                    dp[i][j] = 1;
                else {
                    int hPaths = 0, vPaths = 0;
                    if(j < n - 1)
                        hPaths = dp[i][j + 1];
                    if(i < m - 1)
                        vPaths = dp[i + 1][j];
                    dp[i][j] = hPaths + vPaths;
                }
            }
        }
        
        return dp[0][0];
    }

    public int solve(int m, int n) { // Optimal Solution : Time Complexity = O(M - 1) or O(N - 1), Space Cpmpexity = O(1)
        int N = n + m - 2;
        int r = m - 1;
        double res = 1;

        for(int i = 1; i <= r; i++) 
            res *= (N - r + i)/i;
        
        return (int) res;
    }
}