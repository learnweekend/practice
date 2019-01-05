package leetcode;

import java.util.Stack;
/**
 * https://leetcode.com/problems/find-the-celebrity
 * https://www.youtube.com/watch?v=LtGnA5L6LIk
 *
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1
 */
public class Celebrity {
	/**
	 *  Use two pointer one is start of the array and another one is from right.
	 *  Loop through the array invoke knows(left, right)
	 *  based on condition increment left pointer or decrement right pointer.
	 *  One person will be left, he/she could be a possible celebrity
	 *  Check this person against all people in another loop and return celebrity if found.
	 *  runtime : O(N), space : O(1);
	 */
	public static int findCelebrityTwoPointer(int n) {
		if (n < 0)
			return -1;

		int left = 0;
		int right = n - 1;

		while (left < right) {
			if (knows(left, right)) {
				left++;
			} else {
				right--;
			}
		}
		int celebrity = left; // or right, both will work
	
		// validate if this is actual celebrity, else return -1;
		for (int i = 0; i < n; i++) {
			if (i != celebrity && (knows(celebrity, i) || !knows(i, celebrity)))
				return -1;
		}
		return celebrity;
	}
	/**
	 * Use stack and push all people onto stack.
	 * Pop two people from stack and discard one person and push the possible celebrity to stack.
	 * One person will be left in the stack.
	 * Check the last person if he/she is a actual celebrity in another loop
	 * runtime : O(N), space : O(N)
	 */
	public static int findCelebrityStack(int n) {
		if (n < 0)
			return -1;

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++)
			stack.push(i);

		while (stack.size() > 1) {
			int A = stack.pop();
			int B = stack.pop();
			if (knows(A, B)) {
				stack.push(B);
			} else {
				stack.push(A);
			}
		}
		int celebrity = stack.pop();  // last person in stack.
		// validate if this is actual celebrity else return -1;
		for (int i = 0; i < n; i++) {
			if (i != celebrity && (knows(celebrity, i) || !knows(i, celebrity)))
				return -1;
		}
		return celebrity;
	}
	
	private static int matrix[][] = 
		{ 
		  { 0, 0, 1, 0 }, 
        { 0, 0, 1, 0 },  
        { 0, 0, 0, 0 }, 
        { 0, 0, 1, 0 } 
      }; 

	public static void main(String[] args) {
		int n = 4;
		System.out.println("celebrity : " + findCelebrityTwoPointer(n));
		System.out.println("celebrity : " +findCelebrityStack(n));
	}

	public static boolean knows(int a, int b) {
		return matrix[a][b] == 1 ? true : false;
	}
}
