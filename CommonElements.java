package com.all;

import java.util.HashSet;
import java.util.Set;

/*
 * Given three sorted arrays, find the first element which is common in three given arrays.
 */
public class CommonElements {
	
	/*
	 * Solution :
	 * 1. store the second and third sorted arrays into a set.
	 * 2. loop through the first array and check if elements exists in both the sets
	 * Runtime : O(K), Space : O(N), where is : max length of array.
	 */
	private static int firstCommonElementV1(int[] first, int[] second, int[] third){
		Set<Integer> sSet = new HashSet<Integer>();
		for(int i : second){
			sSet.add(i);
		}
		Set<Integer> tSet = new HashSet<Integer>();
		for(int j : third){
			tSet.add(j);
		}
		
		for(int k = 0; k < first.length; k++){
			if(sSet.contains(first[k]) && tSet.contains(first[k])) {
				return first[k];
			}
		}
		return -1;
	}
	
	/* Solution : 
	 * 1. loop through all the arrays at once and compare the elements
	 * 2. Move the index from each array forward after the comparison.
	 * 3. Check if all index values are same and return.
	 * Runtime : O(n1 + n2 + n3), space : O(1);
	 */
	private static int firstCommonElement(int[] first, int[] second, int[] third){
		int i = 0; int j = 0; int k = 0;
		while(i < first.length && j < second.length && k < third.length){
			
			if(first[i] == second[j] && second[j] == third[k]){
				return first[i];
			} 
			else if(first[i] < second[j]){
				i++;
			} else if(second[j] < third[k]){
				j++;
			} else {
				k++;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		/*int ar1[] = {1, 5};
		int ar2[] = {3, 4, 5, 10};
		int ar3[] = {5, 10, 20};*/
		
		int ar1[] = {1, 5, 10, 20, 40, 80};
		int ar2[] = {6, 7, 20, 80, 100};
		int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};
		
		System.out.println(firstCommonElementV1(ar1, ar2, ar3));
		System.out.println(firstCommonElement(ar1, ar2, ar3));
	}

}
