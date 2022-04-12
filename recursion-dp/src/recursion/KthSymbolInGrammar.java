package recursion;

public class KthSymbolInGrammar {

    public static void main(String[] args) {
        System.out.println(solve(4,6));
    }


    static int solve(int n , int k) {
        // Base condition
        if(n ==1 && k == 1 ) {
            return 0;
        }

        int mid = (int) (Math.pow(2 , n-1) /2);
        if(k <= mid) {
            return solve(n - 1, mid);
        } else {
            int data = 1;
            if(solve(n-1 , k - mid) == 1) {
              data = 0;
            }
            return data;
        }
    }
}
