/* ARRAYS - ARRANGEMENT																Date: 12-May-2021
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note that if you end up using an additional array, you will only receive partial score.

Example:

If the array is

[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:

[
    [3, 1],
    [4, 2]
]
*/

import java.util.ArrayList;

public class rotate_matrix {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
	    for(int i = 0; i < a.size(); i++) { // first we need to transpose the given matrix
	        for(int j = i; j < a.get(i).size(); j++) {
	            int temp = a.get(i).get(j);
	            a.get(i).set(j, a.get(j).get(i));
	            a.get(j).set(i, temp);
	        }
	    }
	    
	    for(int i = 0; i < a.size(); i++) { // now we need to reverse each row in order to get the specified result
	        int li = 0, ri = a.get(i).size() - 1;
	        
	        while(li < ri) {
	            int t = a.get(i).get(li);
	            a.get(i).set(li, a.get(i).get(ri));
	            a.get(i).set(ri, t);
	            
	            li++;
	            ri--;
	        }
	    }
	}
}
