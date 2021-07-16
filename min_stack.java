/* STACKS & QUEUES                                                           Date: 09-July-2021
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
 


Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
*/

import java.util.*;

public class min_stack {
    Stack<Long> st;
    long min;
    
    public min_stack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.size() == 0) {
            st.push((long)val);
            min = val;
        }
        
        else if(val < min) {
            long temp = min; 
            min = val;
            
            long y = val;
            y = 2*y - temp;
            st.push(y);
        }
        
        else
            st.push((long)val);
    }
    
    public void pop() {
        if(st.size() == 0)
            return;
        if(st.peek() < min) 
            min = 2*min - st.peek();
            
        st.pop();
    }
    
    public int top() {
        if(st.size() == 0)
            return -1;
        if(st.peek() < min) 
            return (int)min;
        
        return (int)(long)st.peek();
    }
    
    public int getMin() {
        if(st.size() == 0)
            return -1;
        return (int)min;
    }
}