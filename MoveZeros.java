import java.util.Arrays;

public class MoveZeros {
	
	/* Move Zeros to End of the Array, runtime : O(N), Space : O(1) */
	
	private static void moveToEnd(int[] arr){
		int index = 0;
		
		for(int i = 0; i < arr.length; i++)
		     if(arr[i] != 0)
			arr[index++] = arr[i];

		while(index < arr.length)
			arr[index++] = 0;
		
		System.out.println(Arrays.toString(arr));
	}
	
	/* Move Zeros to Start of the Array, runtime : O(N), Space : O(1) */
	
	private static void moveToStart(int[] arr){
		int index = arr.length - 1;
		
		for(int i = arr.length - 1; i >= 0; i--)
		    if(arr[i] != 0)
		       arr[index--] = arr[i];

		while(index >= 0)
		     arr[index--] = 0;
		
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
	      moveToEnd(new int[] {0, 2, 4, 0, 1, 0, 0, 3, 2});
	      moveToStart(new int[] {0, 2, 4, 0, 1, 0, 0, 3, 2});
	}
}
