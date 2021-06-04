/* STRINGS                                                                      Date: 04-Jun-2021
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

1. Read in and ignore any leading whitespace.
2. Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
3. Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
5. If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.

Note:
Only the space character ' ' is considered a whitespace character.
Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
*/

public class string_to_integer_atoi {
    public int myAtoi(String s) {
        if(s.isEmpty() || s == null)
            return 0;
        
        int i = 0, sign = 1;
        
        while(i < s.length() && s.charAt(i) == ' ') // to ignore all whitespaces
            ++i;
        
        if(i >= s.length())
            return 0;
        
        if(s.charAt(i) == '+' || s.charAt(i) == '-') // to get the sign of the number i.e. positive or negative number
            sign = s.charAt(i++) == '+' ? 1 : -1;
        
        long res = 0;
        while(i < s.length() && Character.isDigit(s.charAt(i))) { // to calc the actual number
            res = res * 10 + (s.charAt(i++) - '0');
            
            // checking overflow condition of int
            if(res * sign > Integer.MAX_VALUE || res * sign < Integer.MIN_VALUE)
              return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;  
        }
        
        return (int)(res * sign);
    }
}