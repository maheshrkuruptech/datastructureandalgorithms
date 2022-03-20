package knapsack;

import java.util.Arrays;

public class KnapSackRecrusion {
   static int [][] memo = new int[10][10];

  public static void main(String[] args) {
    int [] profit  = new int[] {1,4,5,7};
    int [] wt  = new int[] {1,3,4,5};
    int capacity = 7;

    prepMemo(memo);

    int maxProfit = knapsack(profit , wt , capacity , profit.length );
    System.out.println(maxProfit);
    prepMemo(memo);

    System.out.println(knapsack(new int[] {1,2,5,6} , new int[]{2,3,4,5} , 8 , 4));
  }


  static int knapsack(int [] val , int[] wt , int remainingCapacity, int i) {

    if (i == 0 || remainingCapacity == 0) {
      return 0;
    }
    if(memo[remainingCapacity][i] != -1) {
      return memo[remainingCapacity][i];
    }
    int result;
    if (wt[i -1 ] <= remainingCapacity) {
      result = Math.max(val[i - 1] + knapsack(val, wt, remainingCapacity - wt[i - 1], i - 1),
          knapsack(val, wt, remainingCapacity, i - 1));

    } else {
      result = knapsack(val, wt, remainingCapacity, i - 1);
    }
    memo[remainingCapacity][ i-1] = result;
    return result;

  }

  static void prepMemo(int [][]memo) {
    for(int i = 0 ; i < memo.length ; i++) {
      for(int j = 0  ; j < memo[i].length ; j++) {
        memo[i][j] = -1;
      }

    }
  }

}
