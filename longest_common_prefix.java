/* STRINGS                                                                      Date: 02-Jun-2021
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Input: strs = ["flower","flow","flight"]
Output: "fl"

Input: strs = ["dog","racecar","car"]
Output: ""
*/

public class longest_common_prefix {
    public String longestCommonPrefix(String[] strs) {
        // base case
        if(strs.length == 1)
            return strs[0];
        
        int minLen = Integer.MAX_VALUE;
        String str = strs[0];
        
        for(int i = 1; i < strs.length; i++) {
            int j = 0, k = 0, idx = 0;
            
            while(j < str.length() && k < strs[i].length()) {
                if(str.charAt(j) == strs[i].charAt(k))
                    idx++;
                else
                    break;
                
                k++;
                j++;
            }
            
            minLen = Math.min(minLen, idx);
        }
        return str.substring(0, minLen);
    }
    // N = strs.length, M = strs[0].length()
    // Time complexity = O(N * M)
    // Space complexity = O(1)
}