/* BIT MANIPULATION                                                           Date: 11-Jun-2021
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 
Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4
*/



import java.util.*;


public class single_number {
    public int singleNumber(final List<Integer> nums) {
        int xor = 0;
        
        for(int n : nums) 
            xor = (xor ^ n); // x ^ x = 0, duplicate numbers are cancelled by doing xor

        return xor;
    }
}
