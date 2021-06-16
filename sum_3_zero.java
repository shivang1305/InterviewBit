/* TWO POINTERS                                                             Date: 16-Jun-2021
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 
Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []
*/

import java.util.*;



public class sum_3_zero {
    // Time Complexity = O(N^2 * logM)
    // Space Complexity = O(M)

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(nums.length < 3)
            return ans;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
            hm.put(nums[i], hm.getOrDefault(hm.get(nums[i]), 0) + 1);
        
        HashSet<List<Integer>> temp = new HashSet<>();
        
        for(int i = 0; i < nums.length - 1; i++) {
            if(hm.get(nums[i]) == 1)
                hm.remove(nums[i]);
            else
                hm.put(nums[i], hm.get(nums[i]) - 1);
            
            
            for(int j = i + 1; j < nums.length; j++) {
                if(hm.get(nums[j]) == 1)
                    hm.remove(nums[j]);
                else
                    hm.put(nums[j], hm.get(nums[j]) - 1);
                
                int c = 0 - (nums[i] + nums[j]);
                
                if(hm.containsKey(c)) {
                    List<Integer> list = new ArrayList<>();
                    
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(c);
                    
                    Collections.sort(list);
                    temp.add(list);
                }
                hm.put(nums[j], hm.getOrDefault(hm.get(nums[j]), 0) + 1);
            }
            hm.put(nums[i], hm.getOrDefault(hm.get(nums[i]), 0) + 1);
        }
        
        for(List<Integer> l : temp)
            ans.add(l);
            
        return ans;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(nums.length < 3)
            return ans;
        
        Arrays.sort(nums); // O(nlogn)
        
        for(int i = 0; i < nums.length; i++) { // O(n)
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])) { // to avoid getting duplicate value of nums[i]
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                
                while(lo < hi) { // O(n) -> two pointer approach (not binary search)
                    if(nums[lo] + nums[hi] == sum) {                        
                        ans.add(Arrays.asList(nums[i], nums[lo], nums[hi])); // put triplets in list
                        
                        while(lo < hi && nums[lo] == nums[lo + 1])
                            lo++;
                        while(lo < hi  && nums[hi] == nums[hi - 1])
                            hi--;
                        
                        lo++;
                        hi--;
                    }
                      
                    else if(nums[lo] + nums[hi] < sum) 
                        lo++;
                    
                    else if(nums[lo] + nums[hi] > -nums[i]) 
                        hi--;
                }
            }
        }
        return ans;
    }
    // Time complexity = O(n^2)
    // Space complexity = O(m)
}
