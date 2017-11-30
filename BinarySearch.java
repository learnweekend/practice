
/*
 Binary search
 Given a sorted array and the target number, search the array and return the index of the element if found
 -1 if not found.
*/

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {1, 2, 4, 5, 8, 45};
		int target = 10;
		System.out.println(binarySearch(arr, target));
		System.out.println(binarySearchR(arr, 0, arr.length - 1, target));
	}
	
	public static int binarySearch(int[] arr, int key){
		if(arr == null || arr.length == 0)
			throw new IllegalArgumentException();
		return binarySearch(arr, 0, arr.length - 1, key);
	}

	// Iterative

	private static int binarySearch(int[] arr, int start, int end, int key){
		
		while(start <= end) {

			int mid = (end - start)/2 + start ;

			if(arr[mid] == key)
				return mid;

			else if(key < arr[mid])
				end = mid - 1;

			else 
				start = mid + 1;
		}
		return -1;
	}

	// recursion

	private static int binarySearchR(int[] arr, int start, int end, int key){

		if(start <= end){
			int mid = start + (end - start)/2;

			if(key == arr[mid])
				return mid;

			else if(key < arr[mid])
				return binarySearchR(arr, start, mid - 1, key);

			else 
				return binarySearchR(arr, mid + 1, end, key);
		}

		return -1;
	}
}