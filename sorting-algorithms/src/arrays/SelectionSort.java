package arrays;

class SelectionSort  {


  static void sort(int input[]) {
    int arrayLength = input.length;

    for (int i = 0; i < arrayLength-1; i++)  {
      int minElementIndex = i;
      // Find the minimum element in unsorted array
      for (int j = i+1; j < arrayLength; j++) {
        if (input[j] < input[minElementIndex])
          minElementIndex = j;
      }

      // Swap the found minimum element with the first element
      int temp = input[minElementIndex];
      input[minElementIndex] = input[i];
      input[i] = temp;
    }
  }

  public static void main(String args[]) {
    int arr[] = {64,25,12,22,11};
    sort(arr);
    System.out.println("Sorted array");
    printArray(arr);
    arr = new int [] {2,9,10, 5,7};
    sort(arr);
    printArray(arr)   ;
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
