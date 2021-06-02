/* BINARY SEARCH -                                                                 Date: 01-Jun-2021
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/

public class search_in_range {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        
        int lo = 0, hi = nums.length - 1;
        int idx = -1;
        
        // Apply binary search to the whole array to get the index of target element
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target) {
                idx = mid;
                break;
            }
            else if(target > nums[mid])
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        
        if(idx == -1) {
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        
        // since the array is sorted so to find out the first and last occurence index of target element we must must left and right till the element is equal to the target element
        int i = idx; 
        while(i - 1 >= 0 && nums[i - 1] == target)
            i--;
        ans[0] = i;
        
        int j = idx;
        while(j + 1 < nums.length && nums[j + 1] == target)
            j++;
        ans[1] = j;
         
        return ans;    
    }
}