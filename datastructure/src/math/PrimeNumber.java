package math;

import java.util.stream.IntStream;

public class PrimeNumber {
  private static boolean isPrime(int n) {
    return n > 1 && IntStream.range(2, n).noneMatch(i -> n % i == 0);

  }

  public static void main(String[] args) {
    System.out.println(isPrime(30));
    int n = 1;
    int k = 50;
    System.out.println(IntStream.iterate(n, e -> e + 1).filter(PrimeNumber::isPrime)
        .mapToDouble(Math::sqrt).limit(k).sum());

  }
}
