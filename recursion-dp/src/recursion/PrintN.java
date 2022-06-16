package recursion;

public class PrintN {


    public static void main(String[] args) {
        // Here both functions , hypothesis is the same. Run on a smaller i/p print n-1
        // Induction step ; it changed.
        printNto1(7);
        System.out.println();
        print1ToN(7);
    }
    static void printNto1(int n ) {
        if(n == 0) {
            return;
        }
        System.out.print(n +",");
        printNto1(n-1);

    }

    static void print1ToN(int n ) {
        if(n == 0) {
            return;
        }
        print1ToN(n-1);
        System.out.print(n + ",");
    }

}


