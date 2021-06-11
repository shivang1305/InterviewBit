/* BIT MANIPULATION                                                           Date: 11-Jun-2021
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99
*/



public class single_number_2 {
    public int singleNumber1(int[] nums) {
        int ans = 0;
        
        for(int i = 0; i < 32; i++) { // checking for each bit of number 
            int sum = 0;
            
            for(int j = 0; j < nums.length; j++) { // checking for each number in array
                if(((nums[j] >> i) & 1) == 1) { // if the curr bit of the curr number is set/on
                    sum++;
                    sum %= 3; // to get within a range of 3 as all the numbers are repeating thrice
                }
            }
            
            if(sum != 0) // for sum = 1 i.e. set bit
                ans |= sum << i; // trace back to the number
        }
        return ans;
    }
    // TIME COMPLEXITY = O(32N)

    // APPROACH 1 -> unable to handle negative ans or values in the array
    public int singleNumber2(int[] nums) {
        int tn = Integer.MAX_VALUE; // 3n
        int tnp1 = 0, tnp2 = 0; // 3n+1, 3n+2
        
        for(int i = 0; i < nums.length; i++) { // O(N)
            int cwtn = tn & nums[i];
            int cwtnp1 = tnp1 & nums[i];
            int cwtnp2 = tnp2 & nums[i];
            
            tn = tn & (~cwtn);
            tnp1 = tnp1 | cwtn;
            
            tnp1 = tnp1 & (~cwtnp1);
            tnp2 = tnp2 | cwtnp1;
            
            tnp2 = tnp2 & (~cwtnp2);
            tn = tn | cwtnp2;
        }
        
        return tnp1;
    }
}
