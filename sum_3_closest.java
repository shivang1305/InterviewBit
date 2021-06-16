/* TWO POINTERS                                                             Date: 16-Jun-2021
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

import java.util.*;


public class sum_3_closest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // O(nlogn)
    
        int minDiff = Integer.MAX_VALUE, res = 0;    
        
        for(int i = 0; i < nums.length - 2; i++) { // O(n)
            // if(i == 0 || (i > 0 && nums[i] != nums[i - 1])) { // to avoid getting duplicate value of nums[i]
                int lo = i + 1, hi = nums.length - 1;
                
                while(lo < hi) { // O(n) -> two pointer approach (not binary search)
                    int sum = nums[i] + nums[lo] + nums[hi];
                    
                    if(Math.abs(sum - target) < minDiff) {                        
                        minDiff = Math.abs(sum - target);
                        res = sum;
                    }
                    
                    if(sum > target)
                        hi--;
                    else
                        lo++;
                }
            // }
        }
        return res;
        // Time complexity = O(n^2)
        // Space complexity = O(1)
    }
}
