/* TWO POINTERS                                                             Date: 16-Jun-2021
Remove duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.

Note that even though we want you to return the new length, make sure to change the original array as well in place

Do not allocate extra space for another array, you must do this in place with constant memory.

Example:
Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2]. 
*/


public class remove_duplicates_sorted_array {
    public int removeDuplicates(int[] nums) { // two pointer approach
        int i = 0, j = 1;
        
        while(j < nums.length) {
            if(nums[i] == nums[j])
                j++;
            else{
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
    // Time complexity = O(N)
    // Space complexity = O(1)
}
