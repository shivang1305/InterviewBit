/* TWO POINTERS                                                             Date: 15-Jun-2021
Given an one-dimensional unsorted array A containing N integers.

You are also given an integer B, find if there exists a pair of elements in the array whose difference is B.

Return 1 if any such pair exists else return 0.

Input 1:
    A = [5, 10, 3, 2, 50, 80]
    B = 78
Output 1:
    1

Input 2:
    A = [-10, 20]
    B = 30
Output : 
    1
*/



import java.util.*;



public class pair_with_given_diff {
    public int solve(ArrayList<Integer> A, int B) { 
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 0; i < A.size(); i++) 
            hs.add(A.get(i));
            
        for(int i = 0; i < A.size(); i++) {
            int x = A.get(i) + B;
            if(B != 0 && hs.contains(x))
                return 1;
        }
        return 0;
    } // Time Complexity = O(N) , Space Complexity = O(N)
}
