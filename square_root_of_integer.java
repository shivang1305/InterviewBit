public class square_root_of_integer {
    public int sqrt(int A) {
        if(A == 0)
            return 0;
            
        int lo = 1, hi = A, ans = 1;
        
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2; // to avoid overflow
            if(mid <= A/mid){ // it is written this way so that mid should not oveflow the range of int 
                ans = mid;
                lo = mid + 1;
            }
            else
                hi = mid - 1;
        }
        return ans;
    }
}
