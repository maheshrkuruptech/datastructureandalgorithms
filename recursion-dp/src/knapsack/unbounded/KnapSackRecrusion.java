package knapsack.unbounded;

public class KnapSackRecrusion {


  public static void main(String[] args) {
    System.out.println(knapsack(new int[] {2,3,5,6,8,10,7} , 10, 6));
  }


  static int knapsack( int[] wt , int remainingCapacity, int i) {

    if (remainingCapacity == 0 || i == 0) {
      System.out.println("here");

      return 1;
    }

    int result;
    if (wt[i] <= remainingCapacity) {
      result =  knapsack(wt, remainingCapacity - wt[i] , i - 1) + knapsack(wt, remainingCapacity - wt[i], i);
    } else {
       result = knapsack( wt, remainingCapacity - wt[i], i - 1);
    }
    return result;
  }


}
