/**
https://leetcode.com/problems/product-of-array-except-self/description/

* Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of
* all the elements of nums except nums[i].
* Solve it without division and in O(n).
* * For example, given [1,2,3,4], return [24,12,8,6].
* Follow up:
* Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the
* purpose of space complexity analysis.)
*/
import java.util.Arrays;

public class ArrayProductExceptSelf {
	public static void main(String[] args) {
		 int[] a = {1, 2, 3, 4};
		//int[] a = { 1, 2 };
    System.out.println(Arrays.toString(findProductExceptSelfV1(a)));
		System.out.println(Arrays.toString(findProductExceptSelfV2(a)));
		System.out.println(Arrays.toString(findProductExceptSelfV3(a)));
	}
 /*
   Brute force solution, loop (2 loops) through the array and calculate product except self
   Runtime : O(N^2)
   Space   : O(N) - output array
 */
  private static int[] findProductExceptSelfV1(int[] arr) {
    if (arr == null || arr.length <= 1)
			return arr;
    int product = 1;
    int[] products =  new int[arr.length];
    Arrays.fill(products, 1);

    for(int i = 0; i < arr.length; i++) {
      for(int j = 0; j < arr.length; j++) {
          if( i != j) {
            product *= arr[j];
          }
      }
      products[i] = product;
      product = 1;
    }
    return products;
  }
  /*
	When we multiply all values of array before and after each index,
	we get our answer — the product of all the integers except arr[i].
	Runtime : O(N) - multiple passes
	Space   : O(N) - only for output array
  */
	private static int[] findProductExceptSelfV2(int[] arr) {
		if (arr == null || arr.length <= 1)
			return arr;
		int[] products = new int[arr.length];
		Arrays.fill(products, 1);
		int product = 1;

		for (int i = 0; i < arr.length; i++) {
			products[i] = products[i] * product;
			product = product * arr[i];
		}
		product = 1;

		for (int i = arr.length - 1; i >= 0; i--) {
			products[i] = products[i] * product;
			product = product * arr[i];
		}
		return products;
	}
	 /*
		When we multiply all values of array before and after each index,
		we get our answer — the product of all the integers except arr[i].
		Runtime : O(N) - single pass
		Space   : O(N) - only for output array
	  */
	private static int[] findProductExceptSelfV3(int[] arr) {
		if (arr == null || arr.length <= 1)
			return arr;
		int[] products = new int[arr.length];
		Arrays.fill(products, 1);
		int left = 1;
		int right = 1;
		int N = arr.length;

		for (int i = 0; i < N; i++) {
			products[i] = products[i] * left;
			left = left * arr[i];
			products[N - 1 - i] = products[N - 1 - i] * right;
			right = right * arr[N - 1 - i];
		}
		return products;
	}

}
