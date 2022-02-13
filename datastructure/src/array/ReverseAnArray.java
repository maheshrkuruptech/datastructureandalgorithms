package array;

import java.util.Arrays;

public class ReverseAnArray {
  public static void main(String[] args) {
    String [] elements = new String[] {"a" , "e" , "i" , "o" , "u" , "m"};
    reverseArray(elements);
  }

  private static void  reverseArray(String[] elements) {
    int mid = elements.length;
    for(int i = 0 ; i < mid  /2 ; i++) {
        String temp  = elements[i];
        elements[i] = elements[mid - i - 1];
        elements[mid - i - 1] = temp;
    }
    System.out.println(Arrays.toString(elements));
  }
}
