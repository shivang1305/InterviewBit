/* STACKS & QUEUES                                                           Date: 16-July-2021
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.
Input 1:
    A =   ["2", "1", "+", "3", "*"]
Output 1:
    9
Explaination 1:
    starting from backside:
    *: ( )*( )
    3: ()*(3)
    +: ( () + () )*(3)
    1: ( () + (1) )*(3)
    2: ( (2) + (1) )*(3)
    ((2)+(1))*(3) = 9


Input 2:
    A = ["4", "13", "5", "/", "+"]
Output 2:
    6
Explaination 2:
    +: ()+()
    /: ()+(() / ())
    5: ()+(() / (5))
    1: ()+((13) / (5))
    4: (4)+((13) / (5))
    (4)+((13) / (5)) = 6

*/



import java.util.*;

public class evaluate_expression {
    public int evalRPN(String[] str) {
        Stack<Integer> st = new Stack<>();

        for(String s : str) {
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int b = st.pop();
                int a = st.pop();

                if(s.equals("+"))
                    st.push(a + b);
                
                if(s.equals("-"))
                    st.push(a - b);

                if(s.equals("*"))
                    st.push(a * b);

                if(s.equals("/"))
                    st.push(a / b);
            }

            else
                st.push(Integer.parseInt(s));
        }

        return st.peek();
    }
}