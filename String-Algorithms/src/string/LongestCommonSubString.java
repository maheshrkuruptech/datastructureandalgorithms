package string;

public class LongestCommonSubString {
  static void printLCSubStr(String X, String Y)  {
    int m = X.length(); int n = Y.length();

    int[][] LCSuff = new int[m+1][n+1];
    int len = 0;

    // To store the index of the cell which contains the
    // maximum value. This cell's index helps in building
    // up the longest common substring from right to left.
    int row = 0, col = 0;

        /* Following steps build LCSuff[m+1][n+1] in bottom
           up fashion. */
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) {
          LCSuff[i][j] = 0;
        }  else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
          LCSuff[i][j] = LCSuff[i - 1][j - 1] + 1;
          if (len < LCSuff[i][j]) {
            len = LCSuff[i][j];
            // this is to help not to start from all the way down , but from where the last 1 is
            row = i;
            col = j;
          }
        }
        else
          LCSuff[i][j] = 0;
      }
    }

    // if true, then no common substring exists
    if (len == 0) {
      System.out.println("No Common Substring");
      return;
    }

    // allocate space for the longest common substring
    String resultStr = "";

    // traverse up diagonally form the (row, col) cell until LCSuff[row][col] != 0
    while (LCSuff[row][col] != 0) {
      // since we take from sub string itself , with X as Row , its row -1
      resultStr = X.charAt(row - 1) + resultStr;
      row--;
      col--;
    }

    // required longest common substring
    System.out.println(resultStr);
  }

  /* Driver program to test above function */
  public static void main(String args[])
  {
    String X = "OldSite:GeeksforGeeks.org";
    String Y = "NewSite:GeeksQuiz.com";

    printLCSubStr(X, Y);
  }
}

