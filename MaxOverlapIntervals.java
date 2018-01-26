package all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Consider a big party where a log register for guest’s entry and exit times is maintained. 
 Find the time at which there are maximum guests in the party. 
 Note that entries in register are not in any order.
	Example:
	Input: arrival[] = {1, 2, 9, 5, 5}
       exit[] = {4, 5, 12, 9, 12}
	First guest in array arrives at 1 and leaves at 4, 
	second guest arrives at 2 and leaves at 5, and so on.
	Output: 5 , There are maximum 3 guests at time 5.
	
	https://www.geeksforgeeks.org/find-the-point-where-maximum-intervals-overlap/
	
 */
public class MaxOverlapIntervals {
	
	private static class Interval {
		private boolean isArrival;
		private int time;
		
		public Interval(boolean isStart, int time) {
			this.isArrival = isStart;
			this.time = time;
		}
	}
	
	/* Get the max overlaps and the time at which the max overlap occurs.
	 * 1. combine all the intervals with boolean isArrival
	 * 2. sort the entire list based on time stamp.
	 * 3. loop through and increment count for each arrival and decrement count for each exit.
	 * 4. track the maxCount and time at which max count occurs.
	 */
	public static int[] findMaxOverlapIntervals(int[] arrivals,  int[] exits) {
		
		if(arrivals == null || arrivals.length == 0) return new int[] {0, 0};
		
		List<Interval> intervals = new ArrayList<>();
		int count = 0;
		int maxCount = 0;
		int timeAtMax = 0;
		
		for(int i = 0; i < arrivals.length; i++) {
			intervals.add(new Interval(true, arrivals[i]));
		}
		
		for(int i = 0; i < exits.length; i++) {
			intervals.add(new Interval(false, exits[i]));
		}
		
		intervals.sort((p1, p2) -> Integer.compare(p1.time, p2.time));  // sort based on time
		
		for(Interval interval : intervals) {
			if(interval.isArrival) {
				count++;   // increment count for each arrival
				if(count > maxCount) {  // update the maxCount and time at which maxCount.
					maxCount = count;
					timeAtMax = interval.time;
				}
			}
			else {
				count--;  // decrement count for each exit
			}
		}
		return new int[] {maxCount, timeAtMax};
	}

	public static void main(String[] args) {
		int[] arrivals = {1, 2, 9, 5, 5 };
		int[] exits = {4, 5, 12, 9, 12 };
		System.out.println(Arrays.toString(findMaxOverlapIntervals(arrivals, exits)));
	}

}
