package arrays;

public class Mergesort {

  public static void main(String args[]) {
    int arr[] = {64,25,12,22,11};
    sort(arr);
    System.out.println("Sorted array");
    printArray(arr);
    arr = new int [] {2,9,10, 5,7};
    sort(arr);
    printArray(arr) ;
    arr = new int [] {4,3,2,10,12,1,5,6};
    sort(arr);
    printArray(arr) ;
    arr = new int [] {6,5,8,9,3,10,15,12,16};
    sort(arr);
    printArray(arr) ;
  }

 public static void sort(int []input) {
    mergeSort(input , input.length);
 }

  public static void mergeSort(int[] input, int arrayLength) {
    if (arrayLength < 2) {
      return;
    }
    int mid = arrayLength / 2;

    int[] leftIndex = new int[mid];
    int[] rightIndex = new int[arrayLength - mid];


    for (int i = 0; i < mid; i++) {
      leftIndex[i] = input[i];
    }

    for (int i = mid; i < arrayLength; i++) {
      rightIndex[i - mid] = input[i];
    }

    mergeSort(leftIndex, mid);

    mergeSort(rightIndex, arrayLength - mid);

    merge(input, leftIndex, rightIndex);
  }

  public static void merge( int[] input, int[] leftArray, int[] rightArray) {

    int leftSortedIndex = 0, rightSortedIndex = 0, sortedIndex = 0;
    int left = leftArray.length;
    int right = rightArray.length;

    while (leftSortedIndex < left && rightSortedIndex < right) {
      if (leftArray[leftSortedIndex] <= rightArray[rightSortedIndex]) {
        input[sortedIndex++] = leftArray[leftSortedIndex++];
      }
      else {
        input[sortedIndex++] = rightArray[rightSortedIndex++];
      }
    }

    // Print remaining of the elements ; based on left or right is largest.
    while (leftSortedIndex < left) {
      input[sortedIndex++] = leftArray[leftSortedIndex++];
    }
    while (rightSortedIndex < right) {
      input[sortedIndex++] = rightArray[rightSortedIndex++];
    }

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
