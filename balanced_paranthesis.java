/* STACKS & QUEUES                                                           Date: 08-July-2021
Given a string A consisting only of '(' and ')'.

You need to find whether parantheses in A is balanced or not ,if it is balanced then return 1 else return 0.

 
Input 1:
 A = "(()())"

Input 2:
 A = "(()"

Output 1:
 1
Output 2:
 0
*/


import java.util.*;


public class balanced_paranthesis {
    public int solve(String s) {
        Queue<Character> q = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if(ch == '(')
                q.add(ch);
            
            else if(ch == ')' && q.size() != 0)
                q.remove();
            
            else if(ch == ')' && q.size() == 0)
                return 0;
        }
        
        return (q.size() == 0) ? 1 : 0;
    }
}
