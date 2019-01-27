package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/course-schedule/description/ There are a total of n courses you
 * have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to first take course
 * 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to
 * finish all courses?
 * 
 * Example 1: Input: 2, [[1,0]] Output: true Explanation: There are a total of 2 courses to take. To
 * take course 1 you should have finished course 0. So it is possible.
 * 
 * Example 2: Input: 2, [[1,0],[0,1]] Output: false Explanation: There are a total of 2 courses to
 * take. To take course 1 you should have finished course 0, and to take course 0 you should also
 * have finished course 1. So it is impossible.
 * 
 * Note: The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 * Read more about how a graph is represented. You may assume that there are no duplicate edges in
 * the input prerequisites.
 */
public class CourseSchedule {

	public static boolean canFinish(int numCourses, int[][] prerequisites) {

		Map<Integer, List<Integer>> depsMap = new HashMap<>();
		Set<Integer> tempMarks = new HashSet<>();
		Set<Integer> permMarks = new HashSet<>();
		Boolean[] hasCycle = new Boolean[] { false };

		for (int[] dep : prerequisites) {
			if (!depsMap.containsKey(dep[0])) {
				depsMap.put(dep[0], new ArrayList<>());
			}
			depsMap.get(dep[0]).add(dep[1]);
		}

		for (int course = 0; course < numCourses; course++) {
			if (!permMarks.contains(course)) {
				visit(course, depsMap, tempMarks, permMarks, hasCycle);
			}
		}
		return hasCycle[0] == true ? false : true;
	}

	private static void visit(int jobId, Map<Integer, List<Integer>> depsMap, Set<Integer> tempMarks,
			Set<Integer> permMarks, Boolean[] hasCycle) {

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
			visit(i, depsMap, tempMarks, permMarks, hasCycle);
		}
		permMarks.add(jobId);
		tempMarks.remove(jobId);
	}

	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = new int[][] {
			{1,0},
			{0, 1}
		};
		System.out.println(canFinish(numCourses, prerequisites));
	}

}
