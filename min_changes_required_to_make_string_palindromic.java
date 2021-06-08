/* STRINGS                                                                Date: 08-Jun-2021
Given an string A. The only operation allowed is to insert characters in the beginning of the string.

Find how many minimum characters are needed to be inserted to make the string a palindrome string.

Input 1:
    A = "ABC"
Output 1:
    2
    Explanation 1:
        Insert 'B' at beginning, string becomes: "BABC".
        Insert 'C' at beginning, string becomes: "CBABC".

Input 2:
    A = "AACECAAAA"
Output 2:
    2
    Explanation 2:
        Insert 'A' at beginning, string becomes: "AAACECAAAA".
        Insert 'A' at beginning, string becomes: "AAAACECAAAA".
*/

// Variation of a classic DP problem i.e. min no of Insertions/Deletions required to make a string palindrome

// Use of KMP(Knuth - Morris - Pratt) Pattern Matching Algorithm to create the KMP table of LPS(Longest Prefix Suffix)

public class min_changes_required_to_make_string_palindromic {
    public int solve(String str) {
        String revStr = new StringBuilder(str).reverse().toString();
        
        String l = str + "$" + revStr; // delemeter is added in b/w of both the strings just to avoid overlapping
        
        int[] p = new int[l.length()]; // LPS(Longest Prefix Suffix) table or KMP table
        
        // i -> suffix boundry
        // j -> prefix boundry
        for(int i = 1; i < l.length(); i++) {
            int j = p[i - 1]; // update prefix boundry
            
            // move to the last prefix boundry match
            while(j > 0 && l.charAt(i) != l.charAt(j)) 
                j = p[j - 1];
                
            // if prefix boundry matches the suffix boundry then increase the prefix length
            if(l.charAt(i) == l.charAt(j))
                p[i] = j + 1;
        }
        
        return l.length() - 1 - p[l.length() - 1] - str.length();
    }
}
