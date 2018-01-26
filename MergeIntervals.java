package all;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Given a collection of intervals, merge all overlapping intervals.
	For example,
	Given [1,3],[2,6],[8,10],[15,18],
	return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {
	
	private static class Interval {
		private int start;
		private int end;
		
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static List<Interval> mergeIntervals(List<Interval> intervals){
		
		/*Collections.sort(intervals, new Comparator<Interval>() { 
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start.compareTo(o2.start);
			}
		}); */
		intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start)); // replacement for above custom comparator.
		
		Stack<Interval> mergedIntervals = new Stack<>();
		mergedIntervals.push(intervals.get(0));
		
		for(int i = 1; i < intervals.size(); i++) {
			Interval top = mergedIntervals.peek();
			Interval curr = intervals.get(i);
			
			if(top.end < curr.start)   // if (top.end < curr.start)
				mergedIntervals.push(curr);  
			
			else if(top.end < curr.end) { //  if top.end < curr.end  ==> merge interval
				top.end = curr.end;   // update top end to curr end.
				mergedIntervals.pop(); // pop from stack
				mergedIntervals.push(top); // push the merged interval to stack.
			}
		}
		return mergedIntervals;
	}


	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
			/*intervals.add(new Interval(1,3));
			intervals.add(new Interval(2,6));
			intervals.add(new Interval(8,10));
			intervals.add(new Interval(15,18));*/
			
			intervals.add(new Interval(1,2));
			intervals.add(new Interval(2,3));
			
		List<Interval> mergedIntervals = mergeIntervals(intervals);
		for(Interval interval : mergedIntervals) {
			System.out.println("[" + interval.start + ", " + interval.end + "]" );
		}
	}

}
