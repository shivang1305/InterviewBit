/* TWO POINTERS                                                             Date: 13-Jun-2021
Find the intersection of two sorted arrays.
OR in other words,
Given 2 sorted arrays, find all the elements which occur in both the arrays.

Example :

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 3 5]

Output : [3 3 5]

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 5]

Output : [3 5]
*/

import java.util.*;


public class intersection_of_two_sorted_arrays {
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        int i = 0, j = 0;
        
        while(i < A.size() && j < B.size()) {
            int a = A.get(i), b = B.get(j);
            
            if(a == b) {
                ans.add(A.get(i));
                i++;
                j++;
            }
            
            else if(a < b)
                i++;
            
            else if(a > b)
                j++;
        }
        
        return ans;
    }
}
