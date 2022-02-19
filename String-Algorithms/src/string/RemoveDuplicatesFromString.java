package string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromString {

  public static void main(String[] args) {

    removeDuplicate("caramel");

  }


  static void removeDuplicate(String input) {
    System.out.println(Arrays.asList(input.split(""))
        .stream()
          .distinct()
              .collect(Collectors.joining()));
    char [] results = input.toCharArray();
    int counter = 0 , x = 0 , length = 0 , i = 0;
    for (i = 0 ; i < input.length() ; i++) {
      x  = results[i] -97;
      if((counter & (1 <<x)) == 0) {
        results[length] = (char)('a' + x);
        counter = counter | (1 << x);
        length++;
      }
    }
    System.out.println(Arrays.copyOfRange(results , 0 , length));
  }

}
