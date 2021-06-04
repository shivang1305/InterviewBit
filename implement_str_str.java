/* STRINGS                                                                      Date: 04-Jun-2021
implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1

Example 3:
Input: haystack = "", needle = ""
Output: 0
*/


public class implement_str_str {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty() || needle.length() == 0)
            return 0;
        
        if(needle.length() > haystack.length() || haystack.length() == 0)
            return -1;
        
        for(int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                // to avoid overflow of the substring
                String part = i + needle.length() > haystack.length() ? "" : haystack.substring(i, i + needle.length());
                
                if(part.equals(needle))
                    return i;
            }
        }
        return -1;
    }
}
