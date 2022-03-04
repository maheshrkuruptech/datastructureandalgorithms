package array;

public class BalancedSplit {

  public static void main(String[] args) {
    System.out.println(balancedSplitExists(new int[] {1, 5, 7, 3,1}));
    System.out.println(balancedSplitExists(new int[] {1, 5, 7, 1}));
    System.out.println(balancedSplitExists(new int[] {1, 5, 7, 3}));
    System.out.println(balancedSplitExists(new int[] {1, 1}));
    System.out.println(balancedSplitExists(new int[] {12, 7 , 6 ,7 , 6}));
  }

  static boolean balancedSplitExists(int[] arr) {
    int pivotIndex = (int)Math.floor(arr.length / 2);
    return partitionAndCalculate(arr , pivotIndex , arr.length -1);
  }

  static boolean partitionAndCalculate(int [] input , int low , int high) {
    int i = low ; int j = high;
    boolean isBalanced = false;
    if(isBalancedSplit(input , low)) {
      return true;
    }
    if(low < high) {
      int pivot = input[low];
      while(i < j) {
        while(input[i] <= pivot && i < high) {
          i++;
        }
        while(input[j] > pivot) {
          j--;
        }
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
      }


      input[low] = input[j];
      input[j] = pivot;

      isBalanced =  partitionAndCalculate(input , low , j-1);
      if(j+1 < input.length) {
        isBalanced =  partitionAndCalculate(input , j+1 , high);
      }
    }
    return isBalanced;

  }

  static boolean isBalancedSplit(int []input , int index) {
    int lhs = 0 ; int rhs = 0;
    for(int i = 0 ;  i < input.length ; i++) {
      if(i < index) {
        lhs+=input[i];
      } else if(i > index) {
        rhs+=input[i];
      }
    }
    if(lhs + input[index] == rhs || lhs == input[index] + rhs) {
      return true;
    }
    return false;
  }



}
