package recursion;

public class Fib {
    public static void main(String[] args) {
        printFib(5);
    }

    static void printFib(int number) {
        if(number == 1 ) {
            System.out.println(number);
            return ;

        }    
        System.out.println(number);
        printFib(number - 1 );

    }
}
