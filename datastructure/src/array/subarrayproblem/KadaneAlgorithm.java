package array.subarrayproblem;

public class KadaneAlgorithm {

  public static void main(String[] args)
  {
    int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

    System.out.println("The sum of contiguous subarray with the " +
        "largest sum is " + kadane(A));
  }

  static int kadane (int [] input) {
    int max  = 0 ;
    int currentTally = 0;
    for(int data : input) {
      currentTally+=data;
      currentTally = Math.max(currentTally , 0);

      max = Math.max(max , currentTally);
    }

    return max;
  }

}
