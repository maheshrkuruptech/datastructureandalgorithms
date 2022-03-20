package fib;

public class FibRecursion {
  static int [] fib = new int[100];
  public static void main(String[] args) {
    System.out.println(fib(6));
  }

  static int fib(int input) {
    if(input == 1 ) {
      fib[input] = 1;
      return 1;
    }
    if(input == 0) {
      fib[input] = 0;
      return 0;
    }
    fib[input] = fib(input -1) + fib(input -2);
    return fib[input];
  }

}
