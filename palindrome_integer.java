/* MATHS - DIGITS OP                                                                 Date: 25-May-2021
Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
Negative numbers are not palindromic.

Example :

Input : 12121
Output : True

Input : 123
Output : False
*/

public class palindrome_integer {
    // METHOD : 1
    public int isPalindrome1(int A) {
        if(A == 0)
            return 1;
        String s = "" + A;
        String str = "";
        while(A > 0) {
            int r = A % 10;
            str += r;
            A /= 10;
        }
        
        if(s.equals(str))
            return 1;
            
        return 0;
    }

    // METHOD : 2
    public int isPalindrome2(int A) {
        if(A == 0)
            return 1;
        int B = A, rev = 0;

        while(A > 0) {
            rev = A % 10 + rev * 10;
            A /= 10;
        }
            
        return B == rev ? 1 : 0;
    }
}
