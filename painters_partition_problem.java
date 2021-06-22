/* BINARY SEARCH                                                             Date: 22-Jun-2021
Given 2 integers A and B and an array of integars C of size N.

Element C[i] represents length of ith board.

You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of board.

Calculate and return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board.

2 painters cannot share a board to paint. That is to say, a board
cannot be painted partially by one painter, and partially by another.
A painter will only paint contiguous boards. Which means a
configuration where painter 1 paints board 1 and 3 but not 2 is
invalid.

Return the ans % 10000003

Input 1:
    A = 2
    B = 5
    C = [1, 10]
Output 1:
    50
Explanation 1:
    Possibility 1:- same painter paints both blocks, time taken = 55units
    Possibility 2:- Painter 1 paints block 1, painter 2 paints block 2, time take = max(5, 50) = 50
    There are no other distinct ways to paint boards.
    ans = 50%10000003

Input 2:
    A = 10
    B = 1
    C = [1, 8, 11, 3]
Output 2:
    11
*/



public class painters_partition_problem {
    public int paint(int A, int B, int[] C) {
        if(A > C.length) // when the number of painters is greater than number of boards
            A = C.length;
            
        long maxBoardLen = 0, boardLenSum = 0;
        
        for(int i = 0; i < C.length; i++) {
            maxBoardLen = Math.max(maxBoardLen, C[i]);
            boardLenSum += C[i]; // max possible time to paint all boards
        }
        
        long lo = maxBoardLen, hi = boardLenSum;
        
        while(lo <= hi) { // apply binary search
            long mid = (hi + lo) >> 1;
            
            int numPainters = findFeasible(C, A, mid);
            
            if(numPainters <= A)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return (int)((lo * B) % 10000003);
    }
    
    // to find out that the our curr mid val is feasible i.e. it is able to allocate boards to painters which are less than equal to A 
    public int findFeasible(int[] C, int A, long mid) { 
        int sum = 0, numPainters = 1;
        
        for(int i = 0; i < C.length; i++) {
            sum += C[i];
            if(sum > mid) {
                sum = C[i];
                numPainters++;
            }
        }
        return numPainters;
    }
}