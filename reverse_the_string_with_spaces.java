/* STRINGS                                                                Date: 09-Jun-2021
Given a string A.

Return the string A after reversing the string word by word.

NOTE:

A sequence of non-space characters constitutes a word.

Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.

If there are multiple spaces between words, reduce them to a single space in the reversed string.

Input 1:
    A = "the sky is blue"
Output 1:
    "blue is sky the"

Input 2:
    A = "this is ib"
Output 2:
    "ib is this"
*/

import java.util.*;




public class reverse_the_string_with_spaces {
    public String solve(String A) {
        ArrayList<String> s = new ArrayList<>();
        String str = "";
        
        // splitting the strings seperated by multiple spaces
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) != ' ')
                str += A.charAt(i);
            
            else {
                if(!(str.equals("") || str.equals(" ")))
                    s.add(str);
                str = "";
            }
                
        }
        
        if(!(str.equals("") || str.equals(" ")))
            s.add(str);
        
        // reversing the string
        for(int i = 0, j = s.size() - 1; i < s.size() / 2 && j >= s.size() / 2; i++, j--) {
            String temp = s.get(i);
            s.set(i, s.get(j));
            s.set(j, temp);
        }
        
        // Converting string array into string again
        String ans = "";
        for(int i = 0; i < s.size(); i++) {
            if(i == 0)
                ans += s.get(i);
            else
                ans += " " + s.get(i);
        }
        return ans.trim(); // to avoid extra spaces in start and end 
    }
}
