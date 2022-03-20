package fib;

public class FibDP {
  public static void main(String[] args) {
    System.out.println(fib(6));
  }

  static int fib(int input) {
    int [] fib = new int[input+1];
    // base condition becomes initialization
    fib[0]  = 0;
    fib[1]  = 1 ;

//    if(input == 1 ) {
//      fib[input] = 1;
//      return 1;
//    }
//    if(input == 0) {
//      fib[input] = 0;
//      return 0;
//    }
    // Same choice condition ; just that its iterative
    for(int i = 2 ; i <= input ; i ++) {
      fib[i] = fib[i -1] + fib[i -2];
    }

    // fib[input] = fib(input -1) + fib(input -2);
    return fib[input];
  }

}
