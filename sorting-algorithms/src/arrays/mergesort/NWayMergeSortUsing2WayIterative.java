package arrays.mergesort;

/**
 * Demonstrated by considering n lists , each having size of 1.
 */
public class NWayMergeSortUsing2WayIterative {

  public static void main(String args[]) {
    int arr[] = {64,25,12,22,11};
    arr = sort(arr);
    System.out.println("Sorted array");
    printArray(arr);

    arr = new int [] {2,9,10, 5,7};
    arr = sort(arr);
    System.out.println("Sorted array");
    printArray(arr) ;

    arr = new int [] {4,3,2,10,12,1,5,6};
    arr = sort(arr);
    System.out.println("Sorted array");
    printArray(arr) ;
  }

  private static int[] sort(int[] input) {
    int [][] input2D = partitionInput(input ,  input.length , 0 , input.length);
    return sortAndMerge(input2D);
  }



  private static int []  sortAndMerge(int [][] input) {

    if(input.length == 1) {
      return input[0];
    }

    int rows = (int)Math.ceil(input.length / 2.0);

    int [] [] result2D = new int[rows][];

    for (int i  = 0 ; i < input.length  ; i = i +2) {
      int resultArrayIndex = (int)Math.ceil(i/2.0);
      if(i + 1 >= input.length) {
        result2D[resultArrayIndex] = input[i] ;
      } else {
        result2D[resultArrayIndex] = sort(input[i +1] , input[i] );
      }
    }

    return sortAndMerge(result2D);
  }

  private static int[]  sort(int [] leftArray , int [] rightArray ) {

    int leftSortedIndex = 0, rightSortedIndex = 0, sortedIndex = 0;
    int left = leftArray.length ; int right = rightArray.length;

    int [] result = new int[leftArray.length + rightArray.length];

    while (leftSortedIndex < left && rightSortedIndex < right) {
      if (leftArray[leftSortedIndex] <= rightArray[rightSortedIndex]) {
        result[sortedIndex++] = leftArray[leftSortedIndex++];
      }
      else {
        result[sortedIndex++] = rightArray[rightSortedIndex++];
      }
    }

    while(leftSortedIndex < left) {
      result[sortedIndex++] = leftArray[leftSortedIndex++];
    }

    while(rightSortedIndex < right) {
      result[sortedIndex++] = rightArray[rightSortedIndex++];
    }

    return  result;
  }



  // Prints the array
  static void printArray(int arr[]) {
    int n = arr.length;
    for (int i=0; i<n; ++i) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  private static int[][] partitionInput(int []input , int high , int low , int arrayLength) {
    int rows = high / (low +1);
    int cols =  arrayLength - rows + 1;
    int [] [] input2D = new int[rows][cols];
    for(int i = 0 ; i < rows ; i ++) {
      for(int j = 0 ; j < cols ; j++ ) {
        input2D[i][j] = input[i+j];
      }
    }
    return input2D;
  }
}
