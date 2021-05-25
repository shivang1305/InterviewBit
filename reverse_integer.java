/* MATHS - DIGITS OP                                                                 Date: 25-May-2021
Reverse digits of an integer.

Example1:

x = 123,

return 321
Example2:

x = -123,

return -321

Return 0 if the result overflows and does not fit in a 32 bit signed integer
*/

public class reverse_integer {
    public int reverse(int A) {
        int B = Math.abs(A);
        int rev = 0;
        while(B > 0) {
            //overflow condition
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && rev%10 > Integer.MAX_VALUE % 10))
                return 0;
            rev = B % 10 + rev * 10;
            B /= 10;
        }
        
        return A < 0 ? rev * -1 : rev;
    }
}
