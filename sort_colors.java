/* TWO POINTERS                                                             Date: 18-Jun-2021
Given an array and a value, remove all the instances of that value in the array. 

Also return the number of elements left in the array after the operation.

It does not matter what is left beyond the expected length.

Example:

If array A is [4, 1, 1, 2, 1, 3]

and value elem is 1, 

then new length is 3, and A is now [4, 2, 3]

Try to do it in less than linear additional space complexity.
*/


import java.util.*;


public class sort_colors {
    public void sortColors(int[] nums) {
        // Approach 1 - Directly sort the array
        Arrays.sort(nums); // O(n.logn)
        
        // Approach 2 - Use counting sort 
        // Time complexity = O(n)
        // Space complexity = O(1)
        
        int count0 = 0, count1 = 0, count2 = 0;
        for(int i = 0; i < nums.length; i++) { // o(n)
            if(nums[i] == 0)
                count0++;
            
            else if(nums[i] == 1)
                count1++;
            
            else 
                count2++;
        }
        
        int i = 0;
        while(count0 != 0) {
            nums[i] = 0;
            i++;
            count0--;
        }
        
        while(count1 != 0) {
            nums[i] = 1;
            i++;
            count1--;
        }
        
        while(count2 != 0) {
            nums[i] = 2;
            i++;
            count2--;
        }
        
        
        // Approach 3 - Variation of Dutch National Flag Algorithm (2 pointer approach)
        // Time complexity = O(n)
        // Space complexity = O(1)
        
        // 0 -> lo = 0, hi -> nums.length - 1 = 2, lo -> hi = 1
        int lo = 0, mid = 0, hi = nums.length - 1;
        
        while(mid <= hi) {
            if(nums[mid] == 0) {
                int t = nums[mid];
                nums[mid] = nums[lo];
                nums[lo] = t;
                
                lo++;
                mid++;
            }
            
            else if(nums[mid] == 1)
                mid++;
            
            else {
                int t = nums[mid];
                nums[mid] = nums[hi];
                nums[hi] = t;
                
                hi--;
            }
        }
    }
}
