/* BIT MANIPULATION                                                           Date: 11-Jun-2021
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

 

Example 1:

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.
Example 2:

Input: nums = [-1,0]
Output: [-1,0]
*/


public class single_number_3 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int n : nums)
            xor = (xor ^ n); // xor of whole array which in end consists of only two non-repeating numbers
        
        int rsbm = (xor & -xor); // right most set bit mask or xor to get last set bit 
        
        int x = 0, y = 0;
        
        // xor the numbers seperately whose right most bit is on and off
        for(int n : nums) {
            if((rsbm & n) == 0) // for off bit
                x = x ^ n;
            else // for on bit
                y = y ^ n;
        }
        
        int[] ans = new int[2];
        ans[0] = x;
        ans[1] = y;
        
        return ans;
    }
}