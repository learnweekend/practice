package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * This problem was asked by LinkedIn.
 * 
 * Given a list of points, a central point, and an integer k, find the nearest k points from the
 * central point.
 * 
 * For example, given the list of points [(0, 0), (5, 4), (3, 1)], the central point (1, 2), and k =
 * 2, return [(0, 0), (3, 1)].
 */
public class NearestKPoints {

	public static List<Point> kNearestPoints(List<Point> points, Point centralPoint, int k) {

		List<Point> kNearestPoint = new ArrayList<>(k); // To store the result

		PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				double distance1 = calculateDistance(p1, centralPoint);
				double distance2 = calculateDistance(p2, centralPoint);

				if (distance2 > distance1) {
					return 1;
				} else if (distance2 < distance1) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		for (Point point : points) { // add points to Heap
			pq.offer(point);
			if (pq.size() > k)
				pq.poll();
		}

		while (!pq.isEmpty()) { // Poll the k nearest points from Heap
			kNearestPoint.add(pq.poll());
		}

		return kNearestPoint;
	}

	public static double calculateDistance(Point p1, Point p2) {
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
	}

	private static class Point {
		private int x;
		private int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		List<Point> points = Arrays.asList(new Point(0, 0), new Point(5, 4), new Point(3, 1));
		Point centralPoint = new Point(1, 2);
		int k = 2;
		List<Point> result = kNearestPoints(points, centralPoint, k);
		for (Point point : result) {
			System.out.println("(" + point.x + "," + point.y + ")");
		}
	}
}
