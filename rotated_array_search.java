/* BINARY SEARCH -                                                                 Date: 31-May-2021
Given an array of integers A of size N and an integer B.

array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

You are given a target value B to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

NOTE:- Array A was sorted in non-decreasing order before rotation.

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
*/

public class rotated_array_search {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        
        while(lo <= hi) {
            int mid = (lo + hi)/2;
            
            if(nums[mid] == target)
                return mid;
            
            else if(nums[lo] <= nums[mid]) {
                if(target >= nums[lo] && target < nums[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
                
            else if(nums[mid] <= nums[hi]) {
                if(target > nums[mid] && target <= nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
        return -1;
    }
}
