package palindrome;

public class MinimumInsertionForPalindrome {

  public static void main(String[] args) {
    String candidate = "banana";
    int [][]dp = new int[candidate.length()][candidate.length()];
   for(int i = 0 ; i< candidate.length() ; i++) {
     for (int j = 0 ; j < candidate.length() ; j ++) {
       dp[i][j] = -1;
     }
   }
    int computeInsertionCost = computeInsertionCost(candidate, dp, 0, candidate.length() - 1);
    System.out.println(computeInsertionCost);
  }


  static int computeInsertionCost(String input , int[][]dp , int begin , int end) {
    // empty string
    if(begin == end || begin > end) {
      return 0;
    }

    //Memoization
    if(dp[begin][end] != -1) {
      return dp[begin][end];
    }
    if(input.charAt(begin) == input.charAt(end)) {
      dp[begin][end] = computeInsertionCost(input , dp , begin + 1 , end -1);
      return dp[begin][end];
    }
    int attemptedRight =  computeInsertionCost(input , dp , begin  , end -1) + 1;
    int attemptedLeft =  computeInsertionCost(input , dp , begin + 1 , end) + 1;
    return  Math.min(attemptedLeft , attemptedRight);

  }

}
