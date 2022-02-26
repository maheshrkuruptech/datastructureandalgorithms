package arrays;

public class HeapSort {




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
    int rootIndex = (int) Math.floor(input.length /2);
    int arrayLength = input.length;

    for(int i = rootIndex ; i  >= 0 ; i--) {
        heapify(input , arrayLength , i);
    }


    for(int i = input.length - 1  ; i > 0 ; i--) {
      int temp = input[0];
      input[0] = input[i];
      input[i] = temp;
      heapify(input  , i ,  0);
    }


  }

  static void heapify (int [] input  , int arrayLength , int rootIndex) {

      int leftChild = 2 * rootIndex + 1;
      int rightChild = 2 * rootIndex + 2;
      int largest = rootIndex;

      if(leftChild < arrayLength && input[leftChild] > input[rootIndex] ) {
        largest = leftChild;
      }
      if(rightChild < arrayLength && input[rightChild] > input[largest]) {
        largest = rightChild;
      }

    if (largest != rootIndex)  {
      int temp = input[rootIndex];
      input[rootIndex] = input[largest];
      input[largest] = temp;
      heapify(input , arrayLength, largest);
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
