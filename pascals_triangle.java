/* ARRAYS - SIMULATION ARRAY                                                         Date: 19-May-2021
Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
*/

import java.util.*;

public class pascals_triangle {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(); // pascal triangle
        ArrayList<Integer> row, pre = null; // to store elements of curr row and prev row 
        
        for(int i = 0; i < A; i++) {
            row = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++) { // every nth row has exactly n no of columns in it
                if(j == 0 || j == i) // 1st and the last element of each row is 1
                    row.add(1);
                    
                else
                    row.add(pre.get(j - 1) + pre.get(j)); // to get the curr element we add the prev row elements
            }
            pre = row; // update the prev row
            res.add(row); // add the curr row to the pascal's triangle
        }
        
        return res;
    }
}
//TIME COMPLEXITY = O(N^2)
//SPACE COMPLEXITY = O(N^2)
