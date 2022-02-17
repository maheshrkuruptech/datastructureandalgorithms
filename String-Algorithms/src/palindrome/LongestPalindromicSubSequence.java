package palindrome;

public class LongestPalindromicSubSequence {


  public static void main(String[] args) {
    String str = "abcecqba";
    str = "abba";
    int n = str.length();
    int [][] a  = new int[n][n];

    for(int i=0;i<n;i++)
    {
      for(int j=0;j<n;j++)
      {
        if(i==j)
          a[i][j] = 1;
        else
          a[i][j] = 0;
      }
    }

    int i, j, cl;
    for (cl=2; cl<=n; cl++)  {
      for (i=0; i<n-cl+1; i++) {
        j = i+cl-1;
        // first encounter is a match
        if (str.charAt(i) == str.charAt(j) && cl == 2) {
          a[i][j] = 2;
        }
        else if (str.charAt(i) == str.charAt(j)) {
          a[i][j] = a[i + 1][j - 1] + 2;
        }
        else {
          a[i][j] = Math.max(a[i][j - 1], a[i + 1][j]);
        }
      }
    }





  int palindrome_length = a[0][n-1];
  char [] palindrome = new char[palindrome_length +1];
     i = 0;
     j = n-1;
    int palindrome_start = 0;
    int palindrome_end = palindrome_length-1;

    while(palindrome_end - palindrome_start >=1)
    {
      if(str.charAt(i) == str.charAt(j))
      {
        palindrome[palindrome_start] = str.charAt(i);
        palindrome[palindrome_end] = str.charAt(i);
        palindrome_start = palindrome_start + 1;
        palindrome_end = palindrome_end - 1;
        i = i+1;
        j = j-1;
      }
      else
      {
        if(a[i+1][j] > a[i][j-1])
        {
          i = i+1;
        }
        else
        {
          j = j-1;
        }
      }

    }
    if(palindrome_end == palindrome_start)
      palindrome[palindrome_end] = str.charAt(i);
    System.out.println("\n Length of the LPS is =>" +  palindrome_length);
    System.out.println("\n The LPS is =>" + String.valueOf(palindrome));
  }
}
