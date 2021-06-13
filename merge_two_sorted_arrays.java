/* TWO POINTERS                                                             Date: 13-Jun-2021
Given two sorted integer arrays A and B, merge B into A as one sorted array.

 Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.

Example :

Input : 
         A : [1 5 8]
         B : [6 9]

Modified A : [1 5 6 8 9]
*/




import java.util.*;

public class merge_two_sorted_arrays {
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i = 0, j = 0;
	    
	    while(i < a.size() && j < b.size()) { // till the end of any one list
	        if(a.get(i) < b.get(j)) 
	            i++;
	        else {
	            a.add(i, b.get(j)); // add in A
	            b.remove(j); // remove from B
	        }
	    }
	    
	    while(i < a.size()) // till the end of A
	        i++;
	    while(j < b.size()) { // till the end of B
	        a.add(i, b.get(j));
	        b.remove(j);
	    }
    }
}