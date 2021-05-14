/* ARRAYS - VALUE RANGES                                                              Date: 14-May-2021
Given a collection of intervals, merge all overlapping intervals.

For example:

Given [1,3],[2,6],[8,10],[15,18],

return [1,6],[8,10],[15,18].

Make sure the returned intervals are sorted.
*/

public class merge_overlapping_intervals {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // sorting the given arraylist of objects
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start); // for integers only as integers cannot be dereferenced directly
            }
        });
        
        int i = 0;
        
        while(i < intervals.size() - 1) {
            if(intervals.get(i).end > intervals.get(i + 1).start) { // overlapping intervals
                Interval newInterval = new Interval(); 
                
                newInterval.start = Math.min(intervals.get(i).start, intervals.get(i + 1).start);
                newInterval.end = Math.max(intervals.get(i).end, intervals.get(i + 1).end);
                
                intervals.remove(i);
                intervals.remove(i);
                
                intervals.add(i, newInterval);
            }
            else
                i++;
        }
        return intervals;
    }
}
