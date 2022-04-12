package knapsack;

public class EqualSumPartition {

  public static void main(String[] args) {
    int [] input = new int[] {1,2,5};
    int sum = 0;
    for(int i = 0 ; i < input.length ; i++) {
        sum+=input[i];
    }
    if(sum % 2 == 0) {
      findSubArrayWithSum(input , sum / 2);
    }


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

}
