/* MATH - NUMBER ENCODING                                                            Date: 21-May-2021
Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

An even number will always be a sum of 2 prime numbers.

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d] 

If a < c OR a==c AND b < d. 
*/

import java.util.*;

public class next_similar_number {
    public String solve(String A) {
        int[] nums = new int[A.length()];
        // put the digits of string into the array
        for(int j = 0; j < A.length(); j++) 
            nums[j] = Integer.parseInt("" + A.charAt(j));
        
        if(nums.length == 0 || nums.length == 1) // base condition
            return "-1";
            
        
        int i = 0;
        for(i = nums.length - 1; i > 0; i--) { // traverse the array in reverse direction
            
            if(nums[i-1] < nums[i]) { // check that at which pt adjacent digits are obeying this condtn
                
                int min = Integer.MAX_VALUE, minIdx = 0;
                for(int j = i; j < nums.length; j++) {
                    if(min > nums[j] && nums[i - 1] < nums[j]) { // obtain the digit which is min but greater than nums[i-1] in the right direction
                        min = nums[j];
                        minIdx = j;
                    }
                }

                // swap nums[i - 1] & nums[minIdx]
                int t = nums[i - 1];
                nums[i - 1] = nums[minIdx];
                nums[minIdx] = t;
                break;
            }
        }
        
        if(i == 0) // no element is swapped which means that digits are sorted already in decreasing order
            return "-1"; // no possible ans in this case
        
        Arrays.sort(nums, i, nums.length); // sort the remaining elements of array in ascending order
        
        String ans = ""; // put the ans in the string and return
        for(int j = 0; j < nums.length; j++)
            ans += nums[j];
            
        return ans;
    }
}
