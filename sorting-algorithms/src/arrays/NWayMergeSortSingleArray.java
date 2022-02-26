package arrays;

import java.util.Arrays;

public class NWayMergeSortSingleArray {





  public static void main(String args[]) {
    int arr[] = {64,25,12,22,11};
    sort(arr);
    System.out.println("Sorted array");
    printArray(arr);

//    arr = new int [] {2,9,10, 5,7};
//    sort(arr);
//    System.out.println("Sorted array");
//    printArray(arr) ;
//
//    arr = new int [] {4,3,2,10,12,1,5,6};
//    sort(arr);
//    System.out.println("Sorted array");
//    printArray(arr) ;
  }

  private static void sort(int[] input) {
    int [][] input2D = partitionInput(input ,  input.length , 0 , input.length);
    sortAndMerge(input2D , input.length);
  }



  private static void sortAndMerge(int [][] input ,  int arrayLength) {
    int rows = input.length / 2;
    int cols =  arrayLength - rows;
    int [] [] result2D = new int[rows][cols];

    for (int i  = 0 ; i < input.length/2  ; i++) {
      result2D[i] = sort(input[i] , input[i+1] );
      if(result2D[i].length < arrayLength) {
        sortAndMerge(result2D, arrayLength);
      }
    }
    System.out.println("to-do");
  }

  private static int[]  sort(int [] inputA , int [] inputB ) {
    int [] result = new int[inputA.length + inputB.length];
    int counter = 0;

      for(int i = 0 ; i < inputA.length ; i ++) {
        result[counter] = inputA[i];
        counter++;
      }
      for(int j = 0 ; j < inputB.length ; j ++) {
        result[counter] = inputB[j];
        counter++;
      }

        Arrays.sort(result);
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
