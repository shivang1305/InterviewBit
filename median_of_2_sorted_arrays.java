/* BINARY SEARCH -                                                                 Date: 31-May-2021
There are two sorted arrays A and B of size m and n respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

The overall run time complexity should be O(log (m+n)).

Sample Input
A : [1 4 5]
B : [2 3]

Sample Output
3

NOTE: IF the number of elements in the merged array is even, then the median is the average of n / 2 th and n/2 + 1th element.
For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5 
*/


import java.util.*;

public class median_of_2_sorted_arrays {
    // DO NOT MODIFY BOTH THE LISTS
    // BRUTE FORCE APPROACH - taking an extra temp arraylist
    public double findMedianSortedArrays1(final List<Integer> a, final List<Integer> b) {
        ArrayList<Integer> temp = new ArrayList<>();
        
        for(int i = 0; i < a.size(); i++) // O(M)
            temp.add(a.get(i));
            
        for(int i = 0; i < b.size(); i++) // O(N)
            temp.add(b.get(i));
            
        Collections.sort(temp); // O(M+Nlog(M+N))
        
        if(temp.size() % 2 != 0)
            return (double)temp.get(temp.size() / 2);
        
        return (double)(temp.get((temp.size() - 1) / 2) + temp.get(((temp.size() - 1) / 2) + 1)) / 2;
    }
    // Time Complexity = O((M+N).log(M+N))
    // Space Complexity = O(M+N) - for temp array required for merging 

    // OPTIMAL Solution : Applying Binary Search to smaller size array
    public double findMedianSortedArrays2(final List<Integer> a, final List<Integer> b) {
        if(a.size() == 0 && b.size() == 0)
            return -1;
        if(a.size() == 0) {
            if(b.size() % 2 == 0)
                return (double)(b.get(b.size()/2 - 1) + b.get(b.size()/2))/2;
            return (double)b.get(b.size()/2);
        }
        if(b.size() == 0) {
            if(a.size() % 2 == 0)
                return (double)(a.get(a.size()/2 - 1) + a.get(a.size()/2))/2;
            return (double)a.get(a.size()/2);
        }
        
        if(a.size() > b.size()) // to set the min size arraylist as 'a' as we apply binary search always on 'a' arraylist
            return findMedianSortedArrays2(b, a);
        
        int lo = 0, hi = a.size();
        
        while(lo <= hi) {
            int cut1 = lo + (hi - lo)/2;
            int cut2 = (a.size() + b.size())/2 - cut1;
            
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : a.get(cut1 - 1);
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : b.get(cut2 - 1);
            
            int r1 = cut1 == a.size() ? Integer.MAX_VALUE : a.get(cut1);
            int r2 = cut2 == b.size() ? Integer.MAX_VALUE : b.get(cut2);
            
            if(l1 > r2) 
                hi = cut1 - 1;
            
            else if(l2 > r1) 
                lo = cut1 + 1;
                
            else 
                return (a.size() + b.size()) % 2 == 0 
                    ? ((double)Math.max(l1, l2) + (double)Math.min(r1, r2)) / 2.0
                    : (double)Math.min(r1, r2);
            
        }
        return -1.0;
    }
    // Time Complexity = O(log(min(M, N)))
    // Space Complexity = O(1)
}