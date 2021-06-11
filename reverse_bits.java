/* BIT MANIPULATION                                                           Date: 11-Jun-2021
Reverse the bits of an 32 bit unsigned integer A.
*/



public class reverse_bits {
    public long reverse(long n) {
        long rev = 0L;
        int j = 0;
        
        for(int i = 31; i >= 0; i--) {
            long mask = (1L << i);
            
            // only set those bit in the reverse number which are set in the orignal number (in a reverse order)
            
            if((n & mask) != 0) {
                
                long setMask = (1L << j);
                
                rev |= setMask; 
            }
            j++; // increase the reverse bit counter every time irrespective of the incoming bit
        }
        return rev;
    }
}
