import java.util.ArrayList;

/* ARRAYS - MATH                                                            Date: 11-May-2021
You are in an infinite 2D grid where you can move in any of the 8 directions

    (x,y) to 
    (x+1, y), 
    (x - 1, y), 
    (x, y+1), 
    (x, y-1), 
    (x-1, y-1), 
    (x+1,y+1), 
    (x-1,y+1), 
    (x+1,y-1) 
You are given a sequence of points and the order in which you need to cover the points.. Give the minimum number of steps in which you can achieve it. You start from the first point.
*/

public class min_steps_infinite_grids {
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        
        if(A.size() == 1)
            return 0;
        
        int steps = 0;
        
        for(int i = 0; i < A.size() - 1; i++) {
            int x1 = A.get(i), y1 = B.get(i);
            int x2 = A.get(i + 1), y2 = B.get(i + 1);
            
            while(x1 != x2 || y1 != y2) {
                if(x1 == x2) { // horizontal movement
                    steps += Math.abs(y2 - y1);
                    break;
                }
                    
                else if(y1 == y2) { //vertical movement
                    steps += Math.abs(x2 - x1);
                    break;
                }

                // daigonal movements
                else if(x2 > x1 && y2 > y1) { 
                    x1++;
                    y1++;
                }
                
                else if(x2 < x1 && y2 < y1) {
                    x1--;
                    y1--;
                }
                
                else if(x2 < x1 && y2 > y1) {
                    x1--;
                    y1++;
                }
                
                else if(x2 > x1 && y2 < y1) {
                    x1++;
                    y1--;
                }
                
                steps++;
            }
        }
        
        return steps;
    }
}