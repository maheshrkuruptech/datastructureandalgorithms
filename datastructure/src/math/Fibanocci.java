package math;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibanocci {

  public static void main(String[] args) {
    System.out.println(
        "Sum of Fib "
            + Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .mapToInt(Integer::intValue)
                .sum());

    // List of Fib:
    System.out.println(
        Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]})
            .limit(10)
            .map(t -> t[0])
            .collect(Collectors.toList()));

    System.out.println(
        Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]})
            .limit(10)
            .map(t -> t[0])
            .map(String::valueOf)
            .collect(Collectors.joining(",")));
    System.out.print("");
        for (int i = 0; i < 10; i++) {
      System.out.print(fib(i) + ",");
        }
  }

  private static int fib(int n) {
    int init = 0;
    if (n == 0) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return 1;
    }
    return fib(n - 2) + fib(n - 1);
  }
}
