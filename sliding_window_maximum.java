/* STACKS & QUEUES                                                           Date: 11-July-2021
Given an array of integers A.  There is a sliding window of size B which 

is moving from the very left of the array to the very right. 

You can only see the w numbers in the window. Each time the sliding window moves 

rightwards by one position. You have to find the maximum for each window. 

The following example will give you more clarity.

The array A is [1 3 -1 -3 5 3 6 7], and B is 3.

Window position	            Max
———————————	              ————————-
[1  3  -1] -3  5  3  6  7	3
1 [3  -1  -3] 5  3  6  7	3
1  3 [-1  -3  5] 3  6  7	5
1  3  -1 [-3  5  3] 6  7	5
1  3  -1  -3 [5  3  6] 7	6
1  3  -1  -3  5 [3  6  7]	7
Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].

Note: If B > length of the array, return 1 element with the max of the array.
*/

import java.util.*;




public class sliding_window_maximum {
    public int[] slidingMaximum(final int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        st.push(nums.length - 1); // pushing the last index in the stack
        
        int[] nge = new int[nums.length];
        nge[nums.length - 1] = nums.length; // for the last index the next greater element is nums.length
        
        // finding the next greater element array
        for(int i = nums.length - 2; i >= 0; i--) {
            while(!st.empty() && nums[i] >= nums[st.peek()])
                st.pop();
            
            if(st.empty())
                nge[i] = nums.length;
            else
                nge[i] = st.peek();
            
            st.push(i);
        }
        
        int j = 0;
        int[] ans = new int[nums.length - k + 1];
        
        for(int i = 0; i <= nums.length - k; i++) {
            if(i != j)
                j = i;
            
            // j will keep on jumping to the next greater index element if it is within the range of window
            while(nge[j] < i + k)
                j = nge[j];
            
            ans[i] = nums[j]; // last index will be the max of that window
        }
        
        return ans;
    }
}
