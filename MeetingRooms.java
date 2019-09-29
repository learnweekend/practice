package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Example 1:

Input: {{0,30},{5,10}, {15,20}} //5,10   15,20   0,30
Output: false

Example 2:

Input: [[7,10],[2,4]]
Output: true

NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

 */
public class MeetingRooms {
	
	// Runtime : O(N log N)
	public static boolean canAttendMeetings(int[][] intervals) {
		if(intervals == null || intervals.length == 0) {
			return true;
		}
		
		Comparator<int[]> comparator = (int[] A, int[] B) -> A[0] - B[0];  // IT works same sorted based on START TIME or END TIME
      Arrays.sort(intervals, comparator);
      for(int i = 0; i < intervals.length - 1; i++) {
      		if(intervals[i][1] > intervals[i + 1][0])  // overlap when end time of first meeting > start time of second meeting
      			return false;
      }
		
      return true;
   }

	public static void main(String[] args) {
		//int[][] meetings = {{7,10},{2,4}}; //2,4,  7,10, true
		int[][] meetings = {{0,30},{5,10}, {15,20}}; // false
		System.out.println(canAttendMeetings(meetings));
	}
}
