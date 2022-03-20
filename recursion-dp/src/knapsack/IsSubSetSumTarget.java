package knapsack;

public class IsSubSetSumTarget {

  public static void main(String[] args) {
    int [] input = new int[] {2,3,7,8,10};
    int target = 11;
    findSubArrayWithSum(input , target);
  }


  static void findSubArrayWithSum(int[] input , int target) {
      boolean [][]dpArray = new boolean[input.length][target+1];

      // initialization
      for(int i = 0  ; i < input.length ; i ++) {
        for (int j = 0 ; j <= target ; j++) {
            if( j == 0) {
              // in the subtree everything is false. So can build an empty subset for target 0
               dpArray[i][j] = true;
            } else if(i == 0){
              dpArray[i][j] = false;
            }else {
              // Actual Logic starts
                if(input[i -1] <= j) {
                    dpArray[i][j] = dpArray[i -1][j] || dpArray[i][j - input[i-1]];
                } else {
                  dpArray[i][j] = dpArray[i-1][j];
                }
            }
        }
      }
      System.out.println(dpArray[input.length - 1][target]);
  }

}
