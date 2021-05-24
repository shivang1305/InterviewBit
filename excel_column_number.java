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

 "A"

Output 1:

 1

Input 2:

 "AB"

Output 2:

 28
*/

public class excel_column_number {
    public int titleToNumber(String str) {
        int ans = 0; // for the first char of str we dont want to multiply with 26 rather we just simply want to add the char from A, that's why ans is initially zero and not 1.
        
        for(int i = 0; i < str.length(); i++) {
            ans *= 26;
            ans += str.charAt(i) - 'A' + 1;
        }
        
        return ans;
    }
}