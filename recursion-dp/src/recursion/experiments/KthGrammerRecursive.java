package recursion.experiments;

public class KthGrammerRecursive {

    public static void main(String[] args) {
        int n = 2, k = 2;
        System.out.println(findKthGrammer( n , k ));
    }
    private static int findKthGrammer(int n , int k ) {
        
        if(n == 1 && k == 1) {
            return 0;
        }
        int mid = (int)Math.pow(2 , n-1)/2;
        if(k <=mid) {
        return findKthGrammer(n - 1, mid);
        } else {
            return findKthGrammer(n -1 , k - mid) == 0 ? 1 : 0;
        }
        

    }
}
