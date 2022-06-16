package knapsack.unbounded;

import java.util.Arrays;

public class KnapSackUnboundedRecrusion {

  public static void main(String[] args) {
    int [] input = new int[] {2,3,5,6,8,10,7};
    System.out.println(findSubArrayWithSumDP(input , 10));
  }

  static int findSubArrayWithSumDP(int[] input , int target) {
    if(target == 0 ) {
      return 1;
    }
    if(input.length <= 0) {
      return 0;
    }
    if(target - input[input.length -1] >=0)
      return findSubArrayWithSumDP(Arrays.copyOf(input , input.length -1 ) , target - input[input.length -1])
              + findSubArrayWithSumDP(Arrays.copyOf(input , input.length -1 ) , target);

    return  findSubArrayWithSumDP(Arrays.copyOf(input , input.length -2) , target);

  }

}
