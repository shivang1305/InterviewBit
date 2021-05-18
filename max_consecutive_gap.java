/* ARRAYS - BUCKETING                                                             Date: 13-May-2021
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Example :

Input : [1, 10, 5]
Output : 5 
Return 0 if the array contains less than 2 elements.
*/

import java.util.*;

public class max_consecutive_gap {
    public int maximumGap(final int[] A) {
        if(A.length < 2) // base case
            return 0;
            
        Arrays.sort(A);
        
        int maxDiff = Integer.MIN_VALUE; 
        for(int i = 0; i < A.length - 1; i++) {
            int diff = A[i + 1] - A[i]; // traversing the array and finding out max diff b/w elements
            maxDiff = Math.max(maxDiff, diff);
        }
        
        return maxDiff;
    }
}
