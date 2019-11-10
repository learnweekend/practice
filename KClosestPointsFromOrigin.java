package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/ We have a list of
 * points on the plane. Find the K closest points to the origin (0, 0).
 * 
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * 
 * You may return the answer in any order. The answer is guaranteed to be unique
 * (except for the order that it is in.)
 * Example 1:
 * 
 * Input: points = [[1,3],[-2,2]], K = 1 Output: [[-2,2]] Explanation: The
 * distance between (1, 3) and the origin is sqrt(10). The distance between (-2,
 * 2) and the origin is sqrt(8). Since sqrt(8) < sqrt(10), (-2, 2) is closer to
 * the origin. We only want the closest K = 1 points from the origin, so the
 * answer is just [[-2,2]]. Example 2:
 * 
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2 Output: [[3,3],[-2,4]] (The
 * answer [[-2,4],[3,3]] would also be accepted.)
 */
public class KClosestPointsFromOrigin {

	public static void main(String[] args) {
		int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		int K = 2;
		int[][] result = kClosest(points, K);
		for (int[] array : result) {
			System.out.println(Arrays.toString(array));
		}
	}

	public static int[][] kClosest(int[][] points, int K) {
		if (points == null || points.length == 0)
			return new int[0][0];

		Comparator<Node> distnaceComparator = new Comparator<Node>() {
			@Override
			public int compare(Node s1, Node s2) {
				if (s2.distance > s1.distance) {
					return 1;
				} else if (s2.distance < s1.distance) {
					return -1;
				} else {
					return 0;
				}
			}
		};

		List<Point> pointsList = getPoints(points);
		PriorityQueue<Node> pq = new PriorityQueue<Node>(distnaceComparator);

		for (Point point : pointsList) {
			double distance = getDistance(point);
			if (pq.size() < K) {
				pq.add(new Node(distance, point));
			} else if (distance < pq.peek().distance) {
				pq.poll();
				pq.add(new Node(distance, point));
			}
		}

		int[][] result = new int[K][2];
		int index = 0;

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			result[index][0] = node.point.x;
			result[index][1] = node.point.y;
			index++;
		}
		return result;
	}

	private static List<Point> getPoints(int[][] points) {
		List<Point> pointsList = new ArrayList<>();
		for (int[] array : points) {
			pointsList.add(new Point(array[0], array[1]));
		}
		return pointsList;
	}

	private static double getDistance(Point point) {
		return Math.sqrt(Math.pow(point.x - 0, 2) + Math.pow(point.y - 0, 2));
	}

	private static class Node {
		private double distance;
		private Point point;

		public Node(double distance, Point point) {
			this.distance = distance;
			this.point = point;
		}
	}

	private static class Point {
		private int x;
		private int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
