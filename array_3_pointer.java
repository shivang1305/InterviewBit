/* TWO POINTERS                                                             Date: 20-Jun-2021
You are given 3 arrays A, B and C. All 3 of the arrays are sorted.

Find i, j, k such that :

max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.

Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))

**abs(x) is absolute value of x and is implemented in the following manner : **

      if (x < 0) return -x;
      else return x;
Example :

Input : 
        A : [1, 4, 10]
        B : [2, 15, 20]
        C : [10, 12]

Output : 5 
         With 10 from A, 15 from B and 10 from C.
*/

import java.util.*;


public class array_3_pointer {
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int ans = Integer.MAX_VALUE, p1 = 0, p2 = 0, p3 = 0;
        
        while(p1 < A.size() && p2 < B.size() && p3 < C.size()) { // Time complexity = O(N)
            int a = Math.abs(A.get(p1) - B.get(p2));
            int b = Math.abs(B.get(p2) - C.get(p3));
            int c = Math.abs(C.get(p3) - A.get(p1));
            
            // obtain the ans with the current value of the pointers
            ans = Math.min(ans, Math.max(a, Math.max(b, c)));
            
            // increment the min value pointer among all three
            if(A.get(p1) <= B.get(p2) && A.get(p1) <= C.get(p3))
                p1++;
                
            else if(B.get(p2) <= A.get(p1) && B.get(p2) <= C.get(p3))
                p2++;
                
            else if(C.get(p3) <= B.get(p2) && C.get(p3) <= A.get(p1))
                p3++;
        }
        return ans;
    }
}