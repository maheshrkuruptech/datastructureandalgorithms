package knapsack;

public class KnapSackDP {

  public static void main(String[] args) {
    int [] profit  = new int[] {1,4,5,7};
    int [] wt  = new int[] {1,3,4,5};
    int capacity = 7;
    // if refer fib ; it should be wt + 1 to get result in last r c .
    int [][] dpArray = new int[wt.length][capacity+1];

    // base condition
    for(int i = 0 ; i < wt.length ; i++) {
      for(int j = 0 ; j <= capacity ; j++) {
          if(i == 0 || j == 0) {
            dpArray[i][j] = 0;
          }
      }
    }

  // Find max Of!!
    for(int i =  1; i < wt.length ; i ++ ) {
      for(int j = 1 ; j <= capacity ; j++) {
        if (wt[i -1] <= j) {
          dpArray[i][j] = Math.max(profit[i -1] + dpArray[i -1][j - wt[i -1]], dpArray[i -1][j]);
        } else {
          dpArray[i][j] = dpArray[i-1][j];
        }
      }
    }

    System.out.println(dpArray[wt.length - 1][capacity]);



  }

}
