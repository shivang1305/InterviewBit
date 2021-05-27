/* BINARY SEARCH - SEARCH ANSWER                                                      Date: 27-May-2021
Given a matrix of integers A of size N x M in which each row is sorted.

Find an return the overall median of the matrix A.

Note: No extra memory is allowed.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.

Input 1:
    A = [   [1, 3, 5],
            [2, 6, 9],
            [3, 6, 9]   ]
Output 1:
    5
Explanation 1:
    A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
    Median is 5. So, we return 5.

Input 2:
    A = [   [5, 17, 100]    ]
Output 2:
    17 ``` Matrix=
*/

import java.util.*;

public class matrix_median {
    // this function returns the total number of elements less than equal to mid
    public int countLessThanEqualToMid(ArrayList<Integer> arr, int mid) {
        int l = 0, h = arr.size() - 1;
        while(l <= h) {
            int m = (l + h)/2;
            if(arr.get(m) <= mid)
                l = m + 1;
                
            else
                h = m - 1;
        }
        return l;
    }
    
    // OPTIMAL SOLUTION
    // Time Complexity = O(N*log M)
    // Space Complexity = O(1)
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int n = A.size(), m = A.get(0).size();
        int lo = 1, hi = (int)10e9; // highest possible number
        
        // binary search 
        while(lo <= hi) {
            int mid = (lo + hi)/2;
            int ct = 0;
            for(int i = 0; i < n; i++) // count the ele in whole matrix
                ct += countLessThanEqualToMid(A.get(i), mid);
                
            if(ct <= (n * m)/2) // for median to be on the right it must follow this condition
                lo = mid + 1; // move right
            else // fort median to be on left
                hi = mid - 1; // move left
        }
        
        return lo;
    }
}
