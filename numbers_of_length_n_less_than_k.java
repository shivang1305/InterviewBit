/* MATHS - ARRAY DP                                                             Date: 23-May-2021
Given a set of digits (A) in sorted order, find how many numbers of length B are possible whose value is less than number C.

 NOTE: All numbers can only have digits from the given set. 
Examples:

	Input:
	  0 1 5  
	  1  
	  2  
	Output:  
	  2 (0 and 1 are possible)  

	Input:
	  0 1 2 5  
	  2  
	  21  
	Output:
	  5 (10, 11, 12, 15, 20 are possible)
*/

import java.util.*;

public class numbers_of_length_n_less_than_k {
    public int solve(ArrayList<Integer> A, int B, int C) {
        
        if(A.size() == 0)
            return 0;
        
        int d = 0, c = C, ans = 0;
        while(c > 0) { // calculating the number of digits of C
            c /= 10;
            d++;
        }
        
        if(B > d)
            return 0; // no valid solution is possible in this case
        
        else if(B < d) {
            
            if(A.get(0) == 0) // since zero cannot be taken as the first digit 
                ans = (A.size() - 1) * (int)Math.pow((double)A.size(), (double)B - 1);
            else 
                ans = (int)Math.pow((double)A.size(), (double)B); // in case when there is no 0 digit
                
            if(B == 1 && A.get(0) == 0) // if we have to take 1 digit numbers then we should also consider zero as valid ans
                ans++;
            
            return ans;
        }
        
        else { // B == d
            if(B == 1) {
                for(int i = 0; i < A.size(); i++) {
                    if(A.get(i) < C)
                        ans++;
                }
                return ans;
            }
            
            // transform C into a temp array
            int[] temp = new int[d];
            for(int i = temp.length - 1; i >= 0; i--) {
                temp[i] = C % 10;
                C /= 10;
            }
            
            int count = 0;
            
            // get the count of all the digits <= temp[0]
            for(int i = 0; i < A.size(); i++) {
                if(A.get(i) == 0)
                    continue;
                else if(A.get(i) > temp[0])
                    break;
                count++;
            }
            
            ans = count * (int)Math.pow((double)A.size(), (double)B - 1); // our ans including all the number forming from the digit temp[0]
            
            int flag = 0, j = 0;
            // now we will se that the first digit of temp is in the A arr or not
            for(int i = 0; i < A.size(); i++) {
                if(A.get(i) == temp[j])
                    flag = 1;
            }
            
            j++;
            
            if(flag == 0) // if not then our prev calculated ans will be the final ans 
                return ans;
                
            while(flag == 1 && j < B) {
                flag = 0;
                int ctr = 0;
                for(int i = 0; i < A.size(); i++) {
                    if(A.get(i) > temp[j])
                        ctr++;
                    if(A.get(i) == temp[j])
                        flag = 1;
                }
                
                ans -= ctr * (int)Math.pow((double)A.size(), (double)B - j - 1); // remove all the numbers greater than C from our prev ans
                j++;
            }
            
            if(j == B && flag == 1) // it means that we have an exact number formed by combining the digits of A as C 
                ans --; // since we have to consider strictly smaller numbers only, so we decrement our ans by 1;
        }
        
        return ans;
    }
}