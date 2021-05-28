/* BINARY SEARCH - SIMPLE                                                        Date: 28-May-2021
Given a matrix of integers A of size N x M and an integer B.

Write an efficient algorithm that searches for integar B in matrix A.

This matrix A has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.
*/

public class matrix_search {
    // BRUTE FORCE APPROACH - TC = O(N*M)
    // traverse the full matrix
    // search for target element linearly in every row of matrix
    
    // BETTER APPROACH - TC = O(N*logM)
    public boolean searchMatrix1(int[][] matrix, int target) {
        int n = matrix[0].length;
       for(int i = 0; i < matrix.length; i++) {
           if(target == matrix[i][0] || target == matrix[i][n - 1])
               return true;
           if(target > matrix[i][0] && target < matrix[i][n - 1]) {
               int lo = 0, hi = n - 1;
               while(lo <= hi) {
                   int mid = (lo + hi)/2;
                   if(matrix[i][mid] == target)
                       return true;
                   if(matrix[i][mid] < target)
                       lo = mid + 1;
                   else
                       hi = mid - 1;
               }
               return false;
           }
        }
        return false;
    }
    
    // This approach will work appropriately only when matrix is rowwise and columnwise sorted
    public boolean searchMatrix2(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = m - 1;
        
        while(i < n && j >= 0) {
            if(target == matrix[i][j])
                return true;
            
            if(target < matrix[i][j])
                j--;
            else
                i++;
        }
        return false;
    }
    
    // Optimal Solution for this problem - Apply binary search on whole matrix at a single go
    // Time complexity = O(log(M * N))
    public boolean searchMatrix3(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;
        
        int n = matrix.length, m = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2; // to avoid overflow condition of mid
            
            if(matrix[mid / m][mid % m] == target)
                return true;
            
            if(matrix[mid / m][mid % m] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return false;
    }
}
