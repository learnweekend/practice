package leetcode;

//AlgoExpert
public class QuickSelect {

	public static int quickSelect(int[] array, int k) {
		return quickSelec(array, 0, array.length - 1, k - 1);
	}

	private static int quickSelec(int[] array, int start, int end, int position) {
		while (true) {
			int pivotIndex = start;
			int leftIndex = start + 1;
			int rightIndex = end;

			while (leftIndex <= rightIndex) {
				if (array[leftIndex] > array[pivotIndex] && array[rightIndex] < array[pivotIndex]) {
					swap(array, leftIndex, rightIndex);
				}
				if (array[leftIndex] <= array[pivotIndex]) {
					leftIndex++;
				}
				if (array[rightIndex] >= array[pivotIndex]) {
					rightIndex--;
				}
			}
			swap(array, pivotIndex, rightIndex);

			if (rightIndex == position) {
				return array[rightIndex];
			}
			if (rightIndex < position) {
				start = rightIndex + 1;
			} else {
				end = rightIndex - 1;
			}
		}
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		int[] array = { 8, 5, 2, 9, 7, 6, 3 };
		int k = 4;
		//System.out.println(quickSelect(array, k));
		System.out.println(quickSelect(new int[] {1, 2, 4, 5, 6, 3, 2, 1, 3, 2, 4, 3, 2, 2, 4, 4, 3, 2, 1}, 2));
	}
}
