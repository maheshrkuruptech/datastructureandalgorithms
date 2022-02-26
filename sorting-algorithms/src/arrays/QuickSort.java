package arrays;

public class QuickSort {


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

  private static void sort(int[] input) {
    quickSort(input , 0 , input.length - 1);
  }

  private static  void quickSort(int []input , int low , int high) {
        int i = low ; int j = high ;
        if(low < high) {
          int pivotElement = input[low];
          // Move elements such that all left is lt pivot , right gt pivot
          boolean completed = false;
          while (!completed) {
            while (input[i] < pivotElement) {
              i++;
            }
            while (input[j] > pivotElement) {
              j--;
            }
            if (j <= i) {
              completed = true;
            }
            swap(input , i , j);
          }

          // Swap to bring pivot element between left and right sorted.
          int swap = input[j];
          input[i] = swap;
          input[j] = pivotElement;

          // Repeat with left array of pivot
          quickSort(input, low, j -1);
          //Repeat with right array of pivot
          quickSort(input, j + 1, high);
        }


  }
  private static void swap(int[] input , int src , int dest) {
    int swap = input[dest];
    input[dest] = input[src];
    input[src] = swap;
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
