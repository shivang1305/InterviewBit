/* TWO POINTERS                                                             Date: 19-Jun-2021
You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.

Find the position of zeros which when flipped will produce maximum continuous series of 1s.

For this problem, return the indices of maximum continuous series of 1s in order.

Example:

Input : 
Array = {1 1 0 1 1 0 0 1 1 1 } 
M = 1

Output : 
[0, 1, 2, 3, 4] 
*/


import java.util.*;


public class max_cont_series_of_1 {
    public ArrayList<Integer> maxone(ArrayList<Integer> nums, int k) {
        int j = -1, count = 0, maxLen = 0, startIdx = 0, endIdx = 0;
        
        for(int i = 0; i < nums.size(); i++) {
            if(nums.get(i) == 0)
                count++;
                
            while(count > k) {
                j++;
                if(nums.get(j) == 0)
                    count--;
            }
            
            int len = i - j;
            if(len > maxLen) {
                maxLen = len;
                startIdx = j + 1;
                endIdx = i;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(startIdx <= endIdx) {
            ans.add(startIdx);
            startIdx++;
        }
        
        return ans;
    }
}
