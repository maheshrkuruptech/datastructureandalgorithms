package string; /**
 ** Java Program to implement Longest Common Subsequence Algorithm
 **/

/** Class  LongestCommonSubsequence **/
public class  LongestCommonSubsequence
{    
    /** function lcs **/
    public String lcs(String str1, String str2)
    {
        int l1 = str1.length();
        int l2 = str2.length();
        int i = 0 ; int j = 0;
        int[][] arr = new int[l1 + 1][l2 + 1];
        // this is the table building logic

        for ( i = 1 ; i < l1; i++)
        {
            for ( j = 1; j < l2 ; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 0;
            }else if (str1.charAt(i -1) == str2.charAt(j-1)) {

                arr[i][j] = arr[i - 1][j - 1] + 1;
              } else {
                arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
              }
            }
        }

      StringBuffer sb = new StringBuffer();
        while (i  > 0 && j > 0) {
            if (str1.charAt(i -1) == str2.charAt(j -1)) {
                sb.append(str1.charAt(i -1));
                i--; j--;
            }
            else if (arr[i - 1][j] > arr[i][j - 1])
                i--;
            else
                j--;
        }

        return sb.reverse().toString();
    }
 
    /** Main Function **/
    public static void main(String[] args)   {
        LongestCommonSubsequence obj = new LongestCommonSubsequence(); 
        String result = obj.lcs("bqdrcvefgh", "abcvdefgh");
        System.out.println("\nLongest Common Subsequence : "+ result);
    }
}


