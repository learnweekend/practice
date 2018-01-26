package all;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 
  * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
    You may assume that the intervals were initially sorted according to their start times.

	Example 1:
	Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

	Example 2:
	Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

	This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
*/
public class InsertInterval {
	
	private static class Interval {
		private int start;
		private int end;
		
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		Stack<Interval> mergedIntervals = new Stack<>();
		intervals.add(newInterval);
		
		if(intervals == null || intervals.size() == 0)
			return mergedIntervals;
		
		intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
		mergedIntervals.push(intervals.get(0));
		
		for(int i = 1; i < intervals.size(); i++) {
			Interval top = mergedIntervals.peek();
			Interval curr = intervals.get(i);
			
			if(top.end < curr.start) 
				mergedIntervals.push(curr);
			else if(top.end < curr.end) {
				top.end = curr.end;
				mergedIntervals.pop();
				mergedIntervals.push(top);
			}
		}
		return mergedIntervals;
   }

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(6,9));
		
		Interval insertInterval = new Interval(2,5);
		
		List<Interval> mergedIntervals = insert(intervals, insertInterval);
		for(Interval interval : mergedIntervals) {
			System.out.println("[" + interval.start + ", " + interval.end + "]" );
		}
	}

}
