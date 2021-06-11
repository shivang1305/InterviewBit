/* STRINGS                                                                Date: 09-Jun-2021
Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.

A word is a maximal substring consisting of non-space characters only.

 
Example 1:
Input: s = "Hello World"
Output: 5

Example 2:
Input: s = " "
Output: 0
*/


public class length_of_last_word {
    public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        
        if(strs.length == 0)
            return 0;
        
        return strs[strs.length - 1].length();
    }
}