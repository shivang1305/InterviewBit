/* MATH - ADHOC                                                                     Date: 21-May-2021
Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

An even number will always be a sum of 2 prime numbers.

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d] 

If a < c OR a==c AND b < d. 
*/

import java.util.*;

public class prime_sum {
    public ArrayList<Integer> primesum(int A) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        boolean[] primeNos = new boolean[A];
        for(int i = 2; i < Math.sqrt(A); i++) {
            for(int j = 2; i*j < A; j++)
                primeNos[i*j] = true; // non prime numbers
        }
        
        for(int i = 2; i < primeNos.length; i++) {
            if(primeNos[i] == false && primeNos[A - i] == false) {
                ans.add(i);
                ans.add(A - i);
                break;
            }
        }
        
        return ans;
    }
}