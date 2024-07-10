package recursion.experiments;

public class TowerOfHanoi {

    // Recursive function to solve Tower of Hanoi puzzle

    public static void solve(int n, char init, char temp , char finals) {
        if (n == 1) {
            System.out.println("Move disc 1 from " + init + " to " + finals);
            return;
        }
        // Move top n-1 discs from fromRod to auxRod using toRod as auxiliary
        solve(n - 1, init, finals, temp);
        // Move the nth disc from fromRod to toRod
        System.out.println("Move disc " + n + " from " + init + " to " + finals);
        // Move the n-1 discs from auxRod to toRod using fromRod as auxiliary
        solve(n - 1, temp, init, finals);
    }

    // Main method to test the Tower of Hanoi solution
    public static void main(String[] args) {
        int n = 4; // Number of discs
        solve(4, 'A', 'B', 'C');
    }
}
