package palindrome;

public class MinimumInsertionInFrontForPalindrome {

  public static void main(String[] args) {
    String candidate = "banana";
    int count = 0;
    while (candidate.length() > 0) {
      // if string becomes palindrome then break
      if (isPalindrome(candidate)) {
        break;
      } else {
        count++;
        candidate = candidate.substring(0, candidate.length() - 1);
      }
    }
    System.out.println(count);
  }

    static boolean isPalindrome(String s) {
           for(int i = 0 , j  = s.length() -1 ; i<=j ;  i++  , j-- ) {
             if(s.charAt(i) !=s.charAt(j)) {
               return  false;
             }
           }
          return true;
    }

}
