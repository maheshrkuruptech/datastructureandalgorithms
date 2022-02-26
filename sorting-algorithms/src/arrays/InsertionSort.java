package arrays;

public class InsertionSort {



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
  }

  private static void sort(int[] input) {

      for(int i = 1  ; i < input.length  ; i++) {
           int counter = i ;
          // Swap from previous until zeroth index
            while (counter > 0) {
                if( input[counter - 1] > input[counter]) {
                  int temp  = input[counter - 1];
                  input[counter - 1] = input[counter];
                  input[counter] = temp;
                }
                counter --;
            }
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
