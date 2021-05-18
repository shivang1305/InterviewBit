/* ARRAYS - BUCKETING                                                             Date: 13-May-2021
Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.

Sample Input:

[3 4 1 4 1]
Sample Output:

1
If there are multiple possible answers ( like in the sample case above ), output any one.

If there is no duplicate, output -1
*/

import java.util.*;

public class duplicate_in_array {
    public int repeatedNumber(final int[] A) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < A.length; i++) {
            if(hm.containsKey(A[i]))
               return A[i]; 
            else 
                hm.put(A[i], 1);
        }
        return -1;
    }
}
