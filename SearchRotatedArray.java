package com.all;

public class SearchRotatedArray {

	public static void main(String[] args) {
		int[] arr = {3,1};
		int target = 1;
		System.out.println(searchInRotatedArray(arr, target));
	}
	
	private static int searchInRotatedArray(int[] arr, int target){
		if(arr == null || arr.length == 0) 
			return -1;
		int start = 0;
		int end = arr.length - 1;
		
		while(start <= end){
			int mid = start + ((end - start)/2);
			
			if(arr[mid] == target)  // if target is middle element
				return mid;
			
			if(arr[start] <= arr[mid]){  // left is sorted
				
				if(target >= arr[start] && target <= arr[mid]){ 
					end = mid - 1;  // search on left side
				} else {
					start = mid + 1;  // search on right side
				}
			} else {  // right is sorted
				if(target >= arr[mid] && target <= arr[end]){ // search on right side
					start = mid + 1;
				} else {
					end = mid - 1;  // search on left side.
				}
			}
		}
		return -1;
	}

}
