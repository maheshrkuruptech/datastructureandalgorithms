package string;

import java.util.Arrays;

public class LongestIncreasingSubsequenceIntArrayDP
{
  public static int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    // set all the dp values to 1
    Arrays.fill(dp, 1);
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j] && dp[i] < dp[j] +1)
          dp[i] = Math.max(dp[i], dp[j] + 1);
      }
    }

    return Arrays.stream(dp).max().getAsInt();
  }

    public static void main(String[] args)
    {
      int [] input = new  int []  {1,4,3,4,2};
      System.out.println( lengthOfLIS(input));
    }
}
