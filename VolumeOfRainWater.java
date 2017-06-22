/*
 Given n non-negative integers representing an elevation map where the width of each bar is 1,
 compute how much water it is able to trap after raining.
*/
public class VolumeOfRainWater {
  public static void main(String[] args){
      //int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};  // 6
      //int[] arr = {3, 0, 0, 2, 0, 4}; // 10
      int[] arr = {2, 0, 2}; // 2
      System.out.println("volume = " + findVolumeOfRainWater(arr));
  }
  /*  Solution : 1. Find the index of the max element in the array.
              2. calculate the volume of water stored left side of max element index by keep tracking the maxSoFar
              3. calculate the volume of water stored after the max element index to end.
    Runtime : O(N), Space  : O(1)
   */
  private static int findVolumeOfRainWater(int[] arr) {
    if(arr == null || arr.length < 3)
        return 0;

    for(int i : arr) // validation for non- non-negative
        if(i < 0)
          return 0;

    int i = 0;
    int maxSoFar = 0;
    int volume = 0;
    int maxIndex = getMaxIndex(arr);

    while(i <= maxIndex) { // from start to maxIndex (include) location
      if(arr[i] > maxSoFar)
          maxSoFar = arr[i];
      else
          volume += maxSoFar - arr[i];
      i++;
    }

    i = arr.length - 1;
    maxSoFar = 0;

    while(i > maxIndex) { // aftr maxIndex location to end
      if(arr[i] > maxSoFar)
          maxSoFar = arr[i];
      else
          volume += maxSoFar - arr[i];
       i--;
    }
    return volume;
  }
  /*
    Helper method to get the max element index in the array
  */
  private static int getMaxIndex(int[] arr) {
    int maxIndex = 0;
    for(int i = 1; i < arr.length; i++) {
      if(arr[i] > arr[maxIndex])
          maxIndex = i;
    }
    //System.out.println("max index = " +maxIndex);
    return maxIndex;
  }
}
