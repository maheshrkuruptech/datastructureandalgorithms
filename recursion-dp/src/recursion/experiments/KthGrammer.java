package recursion.experiments;

public class KthGrammer {

    public static void main(String[] args) {
        int n = 2, k = 1;
        System.out.println(findKthGrammer( n , k ));
    }
    private static int findKthGrammer(int n , int k ) {
        int curr = 0;
        int left = 1 ;
        int  right = (int)Math.pow(2, n-1);      
       while (n > 1) { 
        int mid = (left+ right) /2;
        if(k <= mid ) {
            right = mid;
        } else {
            left = mid + 1;
            curr =  curr == 0 ? 1 : 0;
        }
        n--;
    }
        return curr;
    }
}
