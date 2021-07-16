/* STACKS & QUEUES                                                           Date: 11-July-2021
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example 1:
    Input: heights = [2,1,5,6,2,3]
    Output: 10
    Explanation: The above is a histogram where width of each bar is 1.
    The largest rectangle is shown in the red area, which has an area = 10 units.
*/

import java.util.*;

public class largest_rectangle_in_histogram {
    public int largestRectangleArea(int[] heights) {
        int[] rb = new int[heights.length]; // for right boundary 
        int[] lb = new int[heights.length]; // for left boundary
        
        // obtaining next smaller element of each element in arr
        Stack<Integer> st = new Stack<>();
        st.push(heights.length - 1);
        rb[heights.length - 1] = heights.length;
        
        for(int i = heights.length - 2; i >= 0; i--) {
            while(!st.empty() && heights[i] <= heights[st.peek()])
                st.pop();
            
            if(st.empty())
                rb[i] = heights.length;
            else
                rb[i] = st.peek();
            
            st.push(i);
        }
        
        // obtaining prev smaller element of each element in arr
        st = new Stack<>();
        st.push(0);
        lb[0] = -1;
        
        for(int i = 1; i < heights.length; i++) {
            while(!st.empty() && heights[i] <= heights[st.peek()])
                st.pop();
            
            if(st.empty())
                lb[i] = -1;
            else
                lb[i] = st.peek();
            
            st.push(i);
        }
        
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
            int area = (rb[i] - lb[i] - 1) * heights[i]; // formula for area
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
    
    // Time complexity = O(n)
    // Space complexity = O(n)
}