/* MATHS - BASE CONVERSION                                                            Date: 24-May-2021
Given a column title A as appears in an Excel sheet, return its corresponding column number.

A  -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 

Input 1:

 1

Output 1:

 "A"

Input 2:

 28

Output 2:

 "AB"
*/


public class excel_column_title {
    public String convertToTitle(int n) {
        String str = "";
            
        while(n > 0) {
            int r = n % 26;
            if(r == 0) { // 26 -> Z
                str = "" + 'Z' + str;
                n /= 26;
                n --;
            }
            
            else {
                char ch = (char)('A' + (r - 1));
                str = "" + ch + str;
                n /= 26;
            }
        }
        return str;
    }
}
