/* ARRAYS - SORTING                                                                Date: 19-May-2021
Given an array of integers, sort the array into a wave like array and return it,
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

Example

Given [1, 2, 3, 4]

One possible answer : [2, 1, 4, 3]  \ / \
Another possible answer : [4, 1, 3, 2]
*/

import java.util.*;

public class wave_integer {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        
        for(int i = 0; i < A.size() - 1; i = i + 2) {
            int t = A.get(i);
            int x = A.get(i + 1);
            A.set(i, x);
            A.set(i + 1, t);
        }
        
        return A;
    }
}
