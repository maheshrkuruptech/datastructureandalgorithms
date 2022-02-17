package array;


/**
 * https://labuladong.gitbook.io/algo-en/i.-dynamic-programming/longestincreasingsubsequence
 *
 */




public class LongestIncreasingSubsequenceIntArrayBS {
  public static int lengthOfLIS(int[] nums) {
    int[] top = new int[nums.length];
    // Initialize the number of piles
    int piles = 0;
    for (int i = 0; i < nums.length; i++) {
      // play cards to be handled
      int cardInHand = nums[i];

      /***** binary search *****/
      int left = 0, right = piles;
      while (left < right) {
        int mid = (left + right) / 2;
        if (top[mid] > cardInHand) {
          right = mid;
        } else if (top[mid] < cardInHand) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }
      /*********************************/

      // create a new pile and put this card into it
      if (left == piles) piles++;
      // put the card on the top
      top[left] = cardInHand;
    }
    // The number of piles represents the length of LIS
    return piles;
  }

  public static void main(String[] args) {
    int [] input = new  int []  {1,4,3,4,2};
    System.out.println(lengthOfLIS(input));
  }
}
