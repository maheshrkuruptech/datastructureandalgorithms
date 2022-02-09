/**
 * Manachers Algorithm for Palindrome.
 * Complexity ; time complexity : O(n)
 *
 */

public class Manachers {


  public static void main(String[] args) {
    man(preProcessString("abb"));
  }


  static  String preProcessString(String candidate) {
    StringBuilder s = new StringBuilder();
    s.append("$").append("#");
    for (int i = 0; i < candidate.length(); i++) {
      s.append(candidate.charAt(i)).append("#");
    }
    s.append("@");
   return s.toString();
  }


  static void man(String candidate) {
    int rightBoundary = 0, mirror = 0, centerPalindrome = 0;
    int T[] = new int[candidate.length()];
    String result = "";
    int max = 0;
    for (int i = 1; i < candidate.length() - 1; i++) {
      mirror = 2 * centerPalindrome - i;

      // if current index is within the right boundary of current palindrome
      // so we know its atleast of this length.
      //copy the mirror length
      if (i < rightBoundary) {
        T[i] = Math.min(rightBoundary - i, T[mirror]);
      }
      // expand until encounter an error
      // we dont start from right adjacent , its from the derived min value from
      // prev step , so we save some in expansion.
      while (candidate.charAt(i + (T[i] + 1)) == candidate.charAt(i - (T[i] + 1))) {
        T[i]++;
      }
      // if current palindrome center  plus what we expanded > current right
      // boundary , update right boundary and mark  the new center palindrome.
      if (i + T[i] > rightBoundary) {
        centerPalindrome = i;
        // right boundary of the current center palindrome
        rightBoundary = i + T[i];
      }

      // Update the current top
      if (T[i] > max) {
        max = T[i];
        result = candidate.substring(i - max, i + max + 1);
      }
    }

    System.out.println(result.replaceAll("#", ""));
  }
}
