public class greatest_common_divisor {
    // METHOD: 1 -> Iterative Approach
    public int gcd1(int A, int B) {
        int a = Math.max(A, B);
        int b = Math.min(A, B);
        
        while(b != 0) {
           int n = a % b;
           a = b;
           b = n;
        }
        
        return a;
    }

    // METHOD : 2 -> Recursive Approach
    public int gcd2(int a, int b) {
        if(a == 0)
            return b;
            
        if(b == 0)
            return a;
            
        if(a > b)
            return gcd2(a%b, b);
            
        return gcd2(a, b%a);
    }
}
