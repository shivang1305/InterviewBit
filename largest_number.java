/* ARRAYS - ARRANGEMENT                                                             Date: 12-May-2021
Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/

import java.util.Arrays;
import java.util.Comparator;

public class largest_number {
    public String largestNumber(final int[] A) {
        if(A.length == 0) // base cases
            return "";
            
        if(A.length == 1) // base cases
            return "" + A[0];
            
        String[] S = new String[A.length];
        for(int i = 0; i < A.length; i++)
            S[i] = Integer.toString(A[i]); // convert to string 
            
        Arrays.sort(S, new Comparator<String>() {
           public int compare(String a, String b) {
               String s1 = a + b;
               String s2 = b + a;
               
               return s2.compareTo(s1);
           } 
        });
        
        if(S[0].equals("0"))
            return "0";
            
        String ans = "";
        for(String s : S) 
            ans += s;
        
        return ans;
    }
}
