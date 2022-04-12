package knapsack.zeroone;

import java.util.Arrays;

public class IsSubSetSumTarget {

  public static void main(String[] args) {
    int [] input = new int[] {2,3,7,8,10};
    int target = 11;
    //findSubArrayWithSum(input , target);
    findSubArrayWithSum(new int[] {1,2,5} , 4);
    System.out.println(findSubArrayWithSumDP(new int[] {1,2,5} , 4));
    findSubArrayWithSum(new int[] {1,5,11,5} , 11);
    System.out.println(findSubArrayWithSumDP(new int[] {1,5,11,5} , 11));
  }


  static void findSubArrayWithSum(int[] input , int target) {
    boolean[][] dpArray = new boolean[input.length][target + 1];
    // initialization
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j <= target; j++) {
        if (j == 0) {
          // in the subtree everything is false. So can build an empty subset for target 0
          dpArray[i][j] = true;
        }
      }
    }

    for (int k = 1; k < input.length; k++) {
      for (int l = 1; l <= target; l++) {

        // Actual Logic starts
        if (input[k - 1] <= l) {
          dpArray[k][l] = dpArray[k - 1][l] || dpArray[k -1][l - input[k - 1]];
        } else {
          dpArray[k][l] = dpArray[k - 1][l];

        }
      }
    }

   System.out.println(dpArray[input.length - 1][target]);
  }

  static boolean findSubArrayWithSumDP(int[] input , int target) {
    if(target == 0 ) {
      System.out.println("true");
      return true;
    }
    if(input.length == 0) {
      return false;
    }
    if(target - input[input.length -1] >=0)
       return findSubArrayWithSumDP(Arrays.copyOf(input , input.length -1) , target - input[input.length -1])
              || findSubArrayWithSumDP(Arrays.copyOf(input , input.length -1) , target);

     return  findSubArrayWithSumDP(Arrays.copyOf(input , input.length -1) , target);

  }

}
