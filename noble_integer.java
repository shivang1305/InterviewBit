/* ARRAYS - SORTING                                                                Date: 19-May-2021
Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p.



Input Format
First and only argument is an integer array A.



Output Format
Return 1 if any such integer p is found else return -1.


Input 1:
 A = [3, 2, 1, 3]

 Input 2:
 A = [1, 1, 3, 3]

Output 1:

 1
Output 2:

 -1

Explanation 1:
 For integer 2, there are 2 greater elements in the array. So, return 1.

Explanation 2:
 There is no such integer exists.

*/

import java.util.*;

public class noble_integer {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        
        int i = 0;
        while(i < A.size() - 1) {
            if(A.get(i) == A.get(i + 1)) // duplicate adjacent elements
                i++;
            
            else {
                int l = A.size() - (i + 1); // length of remaining array
                if(l == A.get(i)) // should be equal to the curr element value
                    return 1;
                i++;
            }
        }
        
        return A.get(i) == 0 ? 1 : -1; // last element 0 means 0 elements are greater than 0 which is a condition for true
    }
}
