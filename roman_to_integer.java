/* STRINGS                                                                Date: 08-Jun-2021
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:
Input: s = "III"
Output: 3

Example 2:
Input: s = "IV"
Output: 4
*/



class roman_to_integer {
    public int romanToInt(String s) {
        int i = 0, ans = 0;
        
        while(i < s.length()) {
            if(i < s.length() - 1 && s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') {
                ans += 4;
                i += 2;
            }
            else if(i < s.length() - 1 && s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') {
                ans += 9;
                i += 2;
            }
            else if(i < s.length() - 1 && s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') {
                ans += 40;
                i += 2;
            }
            else if(i < s.length() - 1 && s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') {
                ans += 90;
                i += 2;
            }
            else if(i < s.length() - 1 && s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') {
                ans += 400;
                i += 2;
            }
            else if(i < s.length() - 1 && s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {
                ans += 900;
                i += 2;
            }
            else if(s.charAt(i) == 'I') {
                ans += 1;
                i++;
            }
            else if(s.charAt(i) == 'V') {
                ans += 5;
                i++;
            }
            else if(s.charAt(i) == 'X') {
                ans += 10;
                i++;
            }
            else if(s.charAt(i) == 'L') {
                ans += 50;
                i++;
            }
            else if(s.charAt(i) == 'C') {
                ans += 100;
                i++;
            }
            else if(s.charAt(i) == 'D') {
                ans += 500;
                i++;
            }
            else if(s.charAt(i) == 'M') {
                ans += 1000;
                i++;
            }
        }
        return ans;
    }
}