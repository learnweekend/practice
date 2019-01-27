package leetcode;

import java.util.*;

/**
 *  https://leetcode.com/problems/course-schedule-ii/description/
 *  
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to first take course
 * 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of
 * courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to
 * finish all courses, return an empty array.
 * 
 * Example 1:
 * 
 * Input: 2, [[1,0]] Output: [0,1] Explanation: There are a total of 2 courses to take. To take
 * course 1 you should have finished course 0. So the correct course order is [0,1] .
 * 
 * Example 2:
 * 
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]] Output: [0,1,2,3] or [0,2,1,3] Explanation: There are a total
 * of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both
 * courses 1 and 2 should be taken after you finished course 0. So one correct course order is
 * [0,1,2,3]. Another correct ordering is [0,2,1
 * 
 * @author suryateja
 *
 */
public class CourseScheduleII {

	public static int[] findOrder(int numCourses, int[][] prerequisites) {

		Map<Integer, List<Integer>> depsMap = new HashMap<>();
		Set<Integer> tempMarks = new HashSet<>();
		Set<Integer> permMarks = new HashSet<>();
		ArrayList<Integer> result = new ArrayList<>();
		Boolean[] hasCycle = new Boolean[] { false };

		for (int[] dep : prerequisites) {
			if (!depsMap.containsKey(dep[0])) {
				depsMap.put(dep[0], new ArrayList<>());
			}
			depsMap.get(dep[0]).add(dep[1]);
		}

		for (int course = 0; course < numCourses; course++) {
			if (!permMarks.contains(course)) {
				visit(course, depsMap, tempMarks, permMarks, hasCycle, result);
			}
		}
		int[] order = new int[numCourses];
		int index = 0;
		for (int i : result) {
			order[index++] = i;
		}
		return hasCycle[0] == true ? new int[0] : order;
	}

	private static void visit(int jobId, Map<Integer, List<Integer>> depsMap, Set<Integer> tempMarks,
			Set<Integer> permMarks, Boolean[] hasCycle, ArrayList<Integer> result) {

		if (tempMarks.contains(jobId)) {
			hasCycle[0] = true;
		}

		if (!permMarks.contains(jobId)) {
			tempMarks.add(jobId);
		}

		if (!depsMap.containsKey(jobId)) {
			depsMap.put(jobId, new ArrayList<Integer>());
		}

		for (int i : depsMap.get(jobId)) {
			if (hasCycle[0])
				return;
			visit(i, depsMap, tempMarks, permMarks, hasCycle, result);
		}
		permMarks.add(jobId);
		tempMarks.remove(jobId);
		if (!result.contains(jobId))
			result.add(jobId);
	}

	public static void main(String[] args) {
		int numCourses = 4;
		int[][] prerequisites = new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
	}

}
