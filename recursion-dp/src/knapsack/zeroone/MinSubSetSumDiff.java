package knapsack.zeroone;

import java.util.Arrays;

public class MinSubSetSumDiff {

  public static void main(String[] args) {

    findSubArrayWithSum(new int[] {1,2,7} , 10);
    findSubArrayWithSum(new int[] {1,2,7,4} , 14);
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

/**
 *
 * This is based on ||  partition ->  s1 ,, Range - s1 ||  =>  range - s1  - s1 is minimum ;
 * Range - 2s1 is minimum. s1 => should be in the range/2 .
 *
 */
    boolean []   finalOne = dpArray[input.length -1];
      int min = Integer.MAX_VALUE;
      for(int i = finalOne.length /2 ; i > 0  ; i --) {
        if(finalOne[i])
        min  = Math.min(min , target - 2*i);
      }
    System.out.println(min);
  }

}
