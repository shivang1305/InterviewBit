/* ARRAYS - SPACE RECYCLE                                                             Date: 18-May-2021
Given an unsorted integer array, find the first missing positive integer.

Example:

Given [1,2,0] return 3,

[3,4,-1,1] return 2,

[-8, -7, -6] returns 1

Your algorithm should run in O(n) time and use constant space.
*/

import java.util.*;

public class first_missing_positive_no {
    public int firstMissingPositive(ArrayList<Integer> A) {
        
        int i = 0;
        while(i < A.size()) {
            if(A.get(i) > 0 && A.get(i) <= A.size() && A.get(i) != A.get(A.get(i) - 1)) {
                int t = A.get(i);
                A.set(i, A.get(A.get(i) - 1));
                A.set(t - 1, t);
            }
            else
                i++;
        }
        
        for(int j = 0; j < A.size(); j++) {
            if(A.get(j) != j + 1)
                return j + 1;
        }
        
        return A.size() + 1;
    }
}
