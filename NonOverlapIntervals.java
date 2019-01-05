package all;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note:
You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
Example 1:
Input: [ [1,2], [2,3], [3,4], [1,3] ]

Output: 1

Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:
Input: [ [1,2], [1,2], [1,2] ]

Output: 2

Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:
Input: [ [1,2], [2,3] ]

Output: 0

Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */
public class NonOverlapIntervals {
	
	public static int eraseOverlapIntervals(Interval[] intervals) {

		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.end - i2.end;
			}
		});

		int end = intervals[0].end;
		int count = 1;
		
		for (int i = 1; i < intervals.length; i++) {
			if(intervals[i].start >= end) {
				end = intervals[i].end;
				count++;
			}
		}
		return (intervals.length - count);
	}
	 
	 private static class Interval {
		 private int start;
		 private int end;
		 
		 public Interval(int start, int end) {
			 this.start = start;
			 this.end = end;
		 }
		 
	 }

	public static void main(String[] args) {
		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(1,2);
		intervals[1] = new Interval(2,3);
		intervals[2] = new Interval(2,3);
		System.out.println(eraseOverlapIntervals(intervals));
	}

}