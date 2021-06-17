/* TWO POINTERS                                                             Date: 16-Jun-2021
Given an array ‘A’ of sorted integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 
Example 1:
Input:  A : [1 3 5] 
        k : 4
Output: 1
*/

import java.util.*;


public class diff_k {
    public int diffPossible(ArrayList<Integer> A, int B) {
        if(A.size() < 2)
            return 0;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < A.size(); i++) 
            hm.put(A.get(i), hm.getOrDefault(A.get(i), 0) + 1);
            
        for(int i = 0; i < A.size(); i++) {
            int x = A.get(i) + B;
            
            if(B == 0 && hm.get(x) > 1)
                return 1;
            else if(B != 0 && hm.containsKey(x))
                return 1;
        }
        return 0;
    }
}