
import java.util.Arrays;

public class MoveZeros {
	
	/**
	 * Runtime : O(N), Space : O(1)
	 */
	private static void moveZerosToRight(int[] arr){
    	    int index = 0;
    	    for(int i = 0; i < arr.length; i++){
      	       if(arr[i] != 0)
        	 arr[index++] = arr[i];
    	    }
           while(index < arr.length)
              arr[index++] = 0;
        }
	
	/**
	 * Runtime : O(N), Space : O(1)
	 */
	private static void moveZerosToLeft(int[] arr) {
	    int index = arr.length - 1;
	    int i = arr.length - 1; // track non-zero element
		
	    while(i >= 0) {
		if(arr[i] != 0) {
		   swap(arr, i, index);
		   index--;
		 }
		 i--;
	     }
	 }

	public static void main(String[] args) {
		moveZerosToLeft(new int[] {1, 2, 3, 0, 0, 4, 0, 5, 0, 6});
		moveZerosToLeft(new int[] {1,0});
		moveZerosToLeft(new int[] {0, 1});
		moveZerosToLeft(new int[] {0});
		
		moveZerosToRight(new int[] {1, 2, 3, 0, 0, 4, 0, 5, 0, 6});
		moveZerosToRight(new int[] {1,0});
		moveZerosToRight(new int[] {0, 1});
		moveZerosToRight(new int[] {0});
	}

}
