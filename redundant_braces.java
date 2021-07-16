/* STACKS & QUEUES                                                           Date: 08-July-2021
Given a string A denoting an expression. It contains the following operators ’+’, ‘-‘, ‘*’, ‘/’.

Chech whether A has redundant braces or not.

Return 1 if A has redundant braces, else return 0.

Note: A will be always a valid expression.

 
Input 1:
    A = "((a + b))"
Output 1:
    1
    Explanation 1:
        ((a + b)) has redundant braces so answer will be 1.

Input 2:
    A = "(a + (a + b))"
Output 2:
    0
    Explanation 2:
        (a + (a + b)) doesn't have have any redundant braces so answer will be 0.
*/

import java.util.*;

public class redundant_braces {
    public int braces(String A) {
        Stack<Character> st = new Stack<>();
        boolean flag = false; // to keep track of arthimetic operation
        
        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            
            if(ch != ')')
                st.push(ch);
                
            else {
                if(st.peek() == '(')
                    return 1;
                else {
                    // every expressn that contains arthimetic operation & is surrounded by braces is valid
                    // rest all is invalid
                    while(st.peek() != '(') {
                        if(st.peek() == '+' || st.peek() == '-' || st.peek() == '*' || st.peek() == '/')
                            flag = true;
                        st.pop();
                    }
                    
                    if(flag == false)
                        return 1;
                    
                    else
                        flag = false;
                        
                    st.pop();
                }
            }
        }
        
        return 0;
    }
}