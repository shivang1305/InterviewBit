/* TWO POINTERS                                                             Date: 17-Jun-2021
Remove Duplicates from Sorted Array

Given a sorted array, remove the duplicates in place such that each element can appear atmost twice and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

Note that even though we want you to return the new length, make sure to change the original array as well in place

For example,
Given input array A = [1,1,1,2],

Your function should return length = 3, and A is now [1,1,2].
*/


public class remove_duplicates_from_sorted_array_2 {
    public int removeDuplicates(int[] nums) {
        int i = 2, j = 2; // since for the first two elements of the array we don't have to do anything either they are equal or not
        
        while(j < nums.length) {
            if(nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}
