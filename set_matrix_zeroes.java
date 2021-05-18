/* ARRAYS - SPACE RECYCLE                                                             Date: 18-May-2021
Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.

Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.

Input 1:
    [   [1, 0, 1],
        [1, 1, 1], 
        [1, 1, 1]   ]

Output 1:
    [   [0, 0, 0],
        [1, 0, 1],
        [1, 0, 1]   ]

Input 2:
    [   [1, 0, 1],
        [1, 1, 1],
        [1, 0, 1]   ]

Output 2:
    [   [0, 0, 0],
        [1, 0, 1],
        [0, 0, 0]   ]
*/

import java.util.*;

public class set_matrix_zeroes {
    public void setZeroes(ArrayList<ArrayList<Integer>> A) {
        // treat the first row and first col of given matrix as dummy matrix to store where the elements to be changed to zero
        int col0 = 1; // true
        
        for(int i = 0; i < A.size(); i++) { // traverse the array 
            if(A.get(i).get(0) == 0) // for 1st col only 
                col0 = 0; // false 
            for(int j = 1; j < A.get(i).size(); j++) {
                if(A.get(i).get(j) == 0) {
                    A.get(i).set(0, 0); // set left most to zero
                    A.get(0).set(j, 0); // set top most to zero
                }
            }
        }
        
        for(int i = A.size() - 1; i >= 0; i--) { // traverse the given matrix backwards
            for(int j = A.get(i).size() - 1; j >= 1; j--) {
                if(A.get(i).get(0) == 0 || A.get(0).get(j) == 0)
                    A.get(i).set(j, 0); // set the curr element to zero as per the top most and left most element
            }
            if(col0 == 0) // in the end set the 1st col element to zero or one as per its boolean value
                A.get(i).set(0, 0);
        }
    }
}