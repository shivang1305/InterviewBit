/* STACKS & QUEUES                                                           Date: 12-July-2021
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
    Input: height = [4,2,0,3,2,5]
    Output: 9
*/

public class rainwater_trapping_problem {
    /* Approach 1 - Obtaining the prefix & suffix max array */
    public int trap(int[] arr) {
        int n = arr.length;
        
        if(n < 3)
            return 0;
        
        int[] rb = new int[n]; // for right boundary 
        int[] lb = new int[n]; // for left boundary
        
        rb[n - 1] = arr[n - 1];
        int rightMax = arr[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            rightMax = Math.max(rightMax, arr[i]);
            rb[i] = rightMax;
        }
        
        lb[0] = arr[0];
        int leftMax = arr[0];
        for(int i = 1; i < n; i++) {
            leftMax = Math.max(leftMax, arr[i]);
            lb[i] = leftMax;
        }
        
        
        int res = 0;
        for(int i = 0; i < n; i++) 
            res += Math.min(lb[i], rb[i]) - arr[i];
        
        return res;
    }

    // Time complexity = O(N)
    // Space complexity = O(2N) (for lb[] & rb[] array)

    /* Approach 2 - 2 Pointer Approach*/

    public int trap2(int[] arr) {
        int n = arr.length;
        
        if(n < 3)
            return 0;
        
        int l = 0, r = n - 1, res = 0;
        int leftMax = arr[0], rightMax = arr[n - 1];
        
        while(l <= r) {
            if(arr[l] <= arr[r]) {
                leftMax = Math.max(leftMax, arr[l]);
                res += leftMax - arr[l];
                l++;
            }
            
            else {
                rightMax = Math.max(rightMax, arr[r]);
                res += rightMax - arr[r];
                r--;
            }
        }
        
        return res;
    }
    
    // Time complexity = O(N)
    // Space complexity = O(1)
}