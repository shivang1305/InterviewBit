/* ARRAYS - VALUE RANGES                                                              Date: 14-May-2021
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Make sure the returned intervals are also sorted.
*/

import java.util.*;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class merge_intervals {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        
        if(intervals.size() == 0) { // base case (no element is present in the given list)
            intervals.add(newInterval);
            return intervals;
        }   
        
        int i = 0;
        while(i < intervals.size()) { // traverse through the list
            
            if(intervals.get(i).end < newInterval.start) // case 1 : upcoming interval
                i++; // simply move forward in the list, nothing needs to be done
                
            else if(intervals.get(i).start > newInterval.end) { // case 3: passed interval
                intervals.add(i, newInterval); // add the new interval to the current position of i
                break; 
            }
            
            else { // case 2: overlapping interval
                
                // obtain the new start and end pts of new interval by streching it accordingly 
                // depending on the type of overlap
                newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
                newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
                
                intervals.remove(i); // delete the orignal interval from the list
            }
        }
        
        if(i == intervals.size()) // when case 3 does not execute in the loop
            intervals.add(newInterval);
        
        return intervals;
    }
}
