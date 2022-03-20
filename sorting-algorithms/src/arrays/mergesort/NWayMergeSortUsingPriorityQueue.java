package arrays.mergesort;

import java.util.PriorityQueue;

/**
 * Demonstrated by considering n lists , each having size of 1.
 */
public class NWayMergeSortUsingPriorityQueue {


  static  class QueueNode implements Comparable<QueueNode> {
    int array , index , value;

    public QueueNode(int array, int index, int value) {
      this.array = array;
      this.index = index;
      this.value = value;
    }

    @Override
    public int compareTo(QueueNode node) {
        if(value > node.value ) return 1;
        if(value < node.value ) return - 1;
        return 0;
    }
  }

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
      PriorityQueue<QueueNode> queue= new PriorityQueue<>();
      int resultantArrayLength = 0;
      for(int i = 0 ; i < input.length ; i ++) {
          resultantArrayLength+=input[i].length;
          queue.add(new QueueNode(i , 0 , input[i][0]));
      }
      int [] result = new int[resultantArrayLength];

      for(int i = 0 ; ! queue.isEmpty() ; i++) {
          QueueNode n = queue.poll();
          result[i] = n.value;
          int nextIndex = n.index +1 ;
          if(nextIndex < input[n.array].length) {
            queue.add(new QueueNode(n.array ,  nextIndex , input[n.array][nextIndex]));
          }
      }
      return result;
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
