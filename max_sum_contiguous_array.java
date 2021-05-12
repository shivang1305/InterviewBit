/* ARRAYS - MATH
Find the contiguous subarray within an array, A of length N which has the largest sum.
*/


public class max_sum_contiguous_array {
    public int maxSubArray(final int[] A) { // Kadane's Algorithm
        int currSum = A[0], maxSum = A[0];
        
        for(int i = 1; i < A.length; i++) {
            if(currSum >= 0)
                currSum += A[i];
            else
                currSum = A[i];
                
            maxSum = Math.max(maxSum, currSum);
        }
        
        return maxSum;
    }
}
