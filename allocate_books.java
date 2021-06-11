/* STRINGS                                                                Date: 10-Jun-2021
Given an array of integers A of size N and an integer B.

College library has N bags,the ith book has A[i] number of pages.

You have to allocate books to B number of students so that maximum number of pages alloted to a student is minimum.

1. A book will be allocated to exactly one student.
2. Each student has to be allocated at least one book.
3. Allotment should be in contiguous order, for example: A student cannot be allocated book 1  and book 3, skipping book 2.

Calculate and return that minimum possible number.

NOTE: Return -1 if a valid assignment is not possible.

Input 1:
    A = [12, 34, 67, 90]
    B = 2
Output 1:
    113
Explanation 1:
    There are 2 number of students. Books can be distributed in following fashion : 
        1) [12] and [34, 67, 90]
        Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
        2) [12, 34] and [67, 90]
        Max number of pages is allocated to student 2 with 67 + 90 = 157 pages 
        3) [12, 34, 67] and [90]
        Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages

        Of the 3 cases, Option 3 has the minimum pages = 113.

Input 2:
    A = [5, 17, 100, 11]
    B = 4
Output 2:
    100
*/



import java.util.*;





public class allocate_books {
    public boolean isAllocationPossible(ArrayList<Integer> arr, int mid, int n) {
        // initially count is 1 as min 1 partition is possible
        int count = 1, s = 0; 
        
        for(int i = 0; i < arr.size(); i++) {
            if(s + arr.get(i) > mid) {
               s = arr.get(i);
               count++; // increasing the number of partitions or the number of students getting books
               
               if(s > mid)
                return false;
            }
            else
                s += arr.get(i);
        }
        
        if(count <= n)
            return true;
        return false;
    }
    
    public int books(ArrayList<Integer> arr, int n) {
        if(n > arr.size()) // base case
            return -1;
        
        int lo = arr.get(0), hi = 0; 
        
        // defining our search space
        for(int i = 0; i < arr.size(); i++) {
            hi += arr.get(i); // sum of all the values of the array
            lo = Math.min(lo, arr.get(i)); // min value of the array
        }
        
        // binary search
        while(lo <= hi) {
            int mid = (lo + hi) >> 1;
            
            if(isAllocationPossible(arr, mid, n))
                hi = mid - 1;
            else 
                lo = mid + 1;
        }
        return lo;
    }
}
