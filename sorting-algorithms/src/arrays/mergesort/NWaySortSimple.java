package arrays.mergesort;

import java.util.Arrays;

public class NWaySortSimple {





  public static void main(String args[]) {
    int arr[] = {64,25,12,22,11};
    sort(arr);
    System.out.println("Sorted array");
    printArray(arr);

    arr = new int [] {2,9,10, 5,7};
    sort(arr);
    System.out.println("Sorted array");
    printArray(arr) ;

    arr = new int [] {4,3,2,10,12,1,5,6};
    sort(arr);
    System.out.println("Sorted array");
    printArray(arr) ;
  }

  private static void sort(int[] input) {
    partitionInput(input ,  input.length , 0 , input.length);
  }

  private static void partitionInput(int []input , int high , int low , int arrayLength) {
        int rows = high / (low +1);
        int cols =  arrayLength - rows + 1;
        int [] [] input2D = new int[rows][cols];
        for(int i = 0 ; i < rows ; i ++) {
              for(int j = 0 ; j < cols ; j++ ) {
               input2D[i][j] = input[i+j];
              }
        }
        sortAndMerge(input2D , arrayLength , input);
  }

  private static void sortAndMerge(int [][] input ,  int size , int [] output) { // traverse the matrix
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < input[i].length; j++) {
        output[i + j] = input[i][j];
      }
    }
    // sort the array
    Arrays.sort(output);
  }




  // Prints the array
  static void printArray(int arr[]) {
    int n = arr.length;
    for (int i=0; i<n; ++i) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
