package palindrome;

public class LongestPalindromeSubstring {



  public int longestPalindromeDynamic(char []str){
    boolean T[][] = new boolean[str.length][str.length];

    for(int i=0; i < T.length; i++){
      T[i][i] = false;
    }

    int max = 1 , len = 0;
    for(int l = 2; l <= str.length; l++){
      for(int i=0; i < str.length-l+1; i++){
        int j = i + l-1;
        len = 0;
        if(l == 2){
          if(str[i] == str[j]){
            T[i][j] = true;
            len = 2;
          }
        }else{
          if(str[i] == str[j] && T[i+1][j-1]){
            T[i][j] = true;
            len = j -i + 1;
          }
        }
        if(len > max){
          max = len;
        }
      }
    }
    return max;
  }

  public static void main(String args[]) {
    LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
    System.out.println(lps.longestPalindromeDynamic("abba".toCharArray()));
    System.out.println(lps.longestPalindromeDynamic("abbababba".toCharArray()));
    System.out.println(lps.longestPalindromeDynamic("babcbaabcbaccba".toCharArray()));
    System.out.println(lps.longestPalindromeDynamic("cdbabcbabdab".toCharArray()));
  }
}
