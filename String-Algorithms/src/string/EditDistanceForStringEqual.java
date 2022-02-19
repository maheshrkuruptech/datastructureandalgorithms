package string;

public class EditDistanceForStringEqual {

  public static void main(String[] args) {
    System.out.println(minDistance("apple" , "da"));

  }

  public static int minDistance(String word1, String word2) {
    int len1 = word1.length();
    int len2 = word2.length();

    // len1+1, len2+1, because finally return dp[len1][len2]
    int[][] dp = new int[len1 + 1][len2 + 1];


    //iterate though, and check last char
    for (int i = 0; i <= len1; i++) {
      for (int j = 0; j <= len2; j++) {
        if(i == 0) {
          dp[i][j] = j;
        } else if (j ==0) {
          dp[i][j] = i;
        } else
        //if last two chars equal
        if (word1.charAt(i -1 ) ==  word2.charAt(j -1)) {
          // carry forward the current value.
          dp[i][j] =  dp[i - 1][j - 1];
        } else {
          // since   math.min cant handle 3 elements.
          int insert = dp[i][j-1] ;
          int delete = dp[i -1][j] ;
          int replace = dp[i -1][j -1];

          int min = replace > insert ? insert : replace;
          min = delete > min ? min : delete;
          dp[i][j] = min +1;
        }
      }
    }

    return dp[len1][len2];
  }
}
