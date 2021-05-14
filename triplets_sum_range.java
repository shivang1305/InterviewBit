/* ARRAYS - BUCKETING                                                             Date: 13-May-2021
Given an array of real numbers greater than zero in form of strings.
Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 .
Return 1 for true or 0 for false.

Example:

Given [0.6, 0.7, 0.8, 1.2, 0.4] ,

You should return 1

as

0.6+0.7+0.4=1.7

1<1.7<2

Hence, the output is 1.

O(n) solution is expected.
*/

public class triplets_sum_range {
    public int solve(String[] A) {
        
        if(A.length < 3) // base case
            return 0;
            
        if(A.length == 3) { // base case (when the array contains only 3 elements)
            double sum = 0;
            
            for(int i = 0; i < A.length; i++) 
                sum += Double.parseDouble(A[i]);
            
            if(sum > 1 && sum < 2)
                return 1;
            else
                return 0;
        }
        
        double[] arr = new double[A.length]; // convert the given string array into double array
        for(int i = 0; i < arr.length; i++) 
            arr[i] = Double.parseDouble(A[i]);
        
        Arrays.sort(arr); // sort the given array
        
        int l = 0, r = arr.length - 1; // two pointers (left and right)
        
        while(l < r - 1) {
            double sum = arr[l] + arr[l + 1] + arr[r];
            
            if(sum > 2)
                r--;
            else if(sum < 1)
                l++;
            else
                return 1;
        }
        
        return 0;
    }
}