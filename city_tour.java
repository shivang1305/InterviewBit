/* MATHS - COMBINATORICS                                                            Date: 25-May-2021
There are A cities numbered from 1 to A. You have already visited M cities, the indices of which are given in an array B of M integers.

If a city with index i is visited, you can visit either the city with index i-1 (i >= 2) or the city with index i+1 (i < A) if they are not already visited.
Eg: if N = 5 and array M consists of [3, 4], then in the first level of moves, you can either visit 2 or 5.

You keep visiting cities in this fashion until all the cities are not visited.
Find the number of ways in which you can visit all the cities modulo 10^9+7.

Input:
    A = 5
    B = [2, 5]
Output:
    6
   
Explanation:
    All possible ways to visit remaining cities are :
    1. 1 -> 3 -> 4
    2. 1 -> 4 -> 3
    3. 3 -> 1 -> 4
    4. 3 -> 4 -> 1
    5. 4 -> 1 -> 3
    6. 4 -> 3 -> 1
*/

import java.util.*;

public class city_tour {
    public int solve(int n, ArrayList<Integer> arr) {
        int len = arr.size();
        if(n - len == 1)
            return 1;
        
        Collections.sort(arr); // O(nlogn)
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        temp.add(arr.get(0) - 1); // left
        for(int i = 1; i < arr.size(); i++) {
            temp.add(arr.get(i) - arr.get(i - 1) - 1); // mid
        }
        temp.add(n - arr.get(arr.size() - 1)); // right
        
        int ans = fact(n - len)/(fact(temp.get(0)) * fact(temp.get(temp.size() - 1)));
        
        for(int j = 1; j < temp.size() - 1; j++) {
            if(temp.get(j) != 0) {
                ans *= ((int)Math.pow((double)2, (double)temp.get(j) - 1)) / fact(temp.get(j));
                ans = ans % 1000000007;
            }
        }
        
        return ans % 1000000007;
    }
    
    public int fact(int n) {
        if(n == 0)
            return 1;
        int f = 1;
        for(int i = 2 ; i <= n; i++) {
            f *= i;
            f = f % 1000000007;
        }
        return f;
    }
}