/* ARRAYS - SIMULATION ARRAY                                                         Date: 19-May-2021
Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
*/

import java.util.*;

public class kth_row_in_pascals_triangle {
    public ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> row = new ArrayList<>();
        int res = 1;
        row.add(res);
        for(int i = 0; i < A; i++) {
            // trick to obtain ncr in constant time i.e. O(1)
            res *= (A - i); // multiply the last obtained ans with (A - i) 
            res /= (i + 1); // divide the last obtained ans with curr row number
            
            row.add(res);
        }
        
        return row;
    }
    // TIME COMPLEXITY = O(N) to traverse till the given row no
    // SPACE COMPLEXITY = O(N) to store the array
}
