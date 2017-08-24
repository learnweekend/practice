/*
 Problem : Matrix Rotation 90 degrees clockwise.
 */

 public class MatrixRotation {

  /*   1 2 3    swap 1 with 3,   swap 1 with 9, swap 1 with 7
       4 5 6
       7 8 9
   */
   private static void rotateMatrixInPlace(int[][] matrix){
  /*   1  2  3  4
       5  6  7  8
       9 10 11 12
      13 14 15 16
  */
     int level = 0;
     int last = matrix.length - 1;
     int noOfLevels = matrix.length/2;

     while(level < noOfLevels){
       for(int i = level; i < last; i++){
         swap(matrix, level, i, i, last);
         swap(matrix, level, i, last, last - i + level);
         swap(matrix, level, i, last - i + level, level);
       }
       level++;
       last--;
     }
   }

   private static void swap(int[][] m, int i, int j, int k, int l) {
     int temp = m[i][j];
     m[i][j] = m[k][l];
     m[k][l] = temp;
   }

   /* Solution 1 : Brute Force approach,
      Runtime : O(N), Space : O(N)
    */
   private static int[][] rotateMatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int col = 0;
		int nRow = 0;
		int[][] result = new int[rows][cols];
		/* 1. Take the first column and convert that to first row in resulted array
		 * 2. Go to next column and follow the step 1.
		 * 3. Repeat the above steps until all columns are converted.
		 */
		while(col < cols) { // start with first column of original matrix
			int nCol = 0; //nCol => new column in resulted array.
			for(int row = rows - 1; row >= 0; row --) { // take first column element from each row.
				result[nRow][nCol] = matrix[row][col]; // add into resulted array
				nCol++; // increment new column index.
			}
			col++; // take the next column from original matrix.
			nRow++; // increment new column row.
		}
		return result;
	}

   private static void printMatrix(int[][] arr){
		int rows = arr.length;
		int cols = arr[0].length;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	 }

   public static void main(String[] args) {
    int[][] matrix =  { { 1, 2, 3, 4 },{ 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }};
		printMatrix(matrix);
		System.out.println();
		//rotateMatrix(matrix);
	  //System.out.println();
		//int[][] result = rotateMatrix(matrix);
		//printMatrix(result);

    rotateMatrixInPlace(matrix); //in place
    printMatrix(matrix);

   }
 }
