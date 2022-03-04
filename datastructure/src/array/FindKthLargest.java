package array;

public class FindKthLargest {

  public static void main(String[] args) {
    int [ ] input = new int[]{3,6,4,7,9,2,1};

    System.out.println(findKthLargestElement(input , 0 , 0 , input.length -1));
    System.out.println(findKthLargestElement(input , 1 , 0 , input.length -1));
    System.out.println(findKthLargestElement(input , 2 , 0 , input.length -1));
    System.out.println(findKthLargestElement(input , 3 , 0 , input.length -1));
    System.out.println(findKthLargestElement(input , 4 , 0 , input.length -1));
    System.out.println(findKthLargestElement(input , 5 , 0 , input.length -1));
    System.out.println(findKthLargestElement(input , 6 , 0 , input.length -1));


  }

  static int findKthLargestElement(int[] input, int k, int low, int high) {
    int i = low ; int j = high ; int res = 0;

      if(low == high) {
        return input[low];
      }
      int pivot = input[low];
      while(i < j) {
        while(input[i] <= pivot && i < high) {
          i++;
        }
        while(input[j] > pivot) {
          j--;
        }
      if (i < j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
        }
    }


    input[low] = input[j];
    input[j] = pivot;

      if (k == input.length - 1  - j) {
          return input[input.length - 1 -  k ];
      }  else if (k < input.length  -1 - j) {
        return findKthLargestElement(input, k, j +1 , high);
      } else {
        return findKthLargestElement(input, k, low, j - 1);
      }
    }



    private static void swap(int[] input , int src , int dest) {
      int swap = input[dest];
      input[dest] = input[src];
      input[src] = swap;
    }


}
