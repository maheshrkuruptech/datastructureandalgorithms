package knapsack.experiments;

public class KnapSack {

    public static void main(String[] args) {
        int [] wt  = new int[] {2,3,1,6,4};
        int [] value  = new int[] {1,2,3,4,5};
        int capacity = 6;
        knapsack(wt, value, capacity);
    }

    private static void knapsack(int [] wt , int [] val , int capacity) {
        // intiialization 
        int [] [] valueGrid = new int[wt.length +1][capacity +1 ];
        for(int i = 0 ; i <= val.length ; i++) {
            for(int j = 0 ; j <=capacity ; j++) { 
                if(i ==0 || j == 0 ) {
                    valueGrid[i][j] = 0;
                }
            }
        }

        for(int i = 1 ; i <= val.length ; i++) {
            for(int j = 1 ; j <= capacity ; j++ ) {
                int tempCap = j - wt[i-1];
                if(tempCap >=0) {
                valueGrid[i][j] = Math.max(val[i-1] + valueGrid[i-1][tempCap] , valueGrid[i-1][j]);
                } else {
                    valueGrid[i][j] = valueGrid[i-1][j];
                }
            }
        }

        System.out.println("done");
    } 

}
