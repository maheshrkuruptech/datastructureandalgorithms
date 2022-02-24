class CurrencyExchange {

  boolean canGetExactChange(int targetMoney, int[] denominations) {
    // Write your code here
      return findCombination(denominations  , denominations.length , targetMoney);
  }
   
  
  static boolean findCombination(int arr[], int n , int target) {
        // A temporary array to store all combination one by one
        int data[]=new int[n];
        int res[] = new int[n];
        // Print all combination using temporary array 'data[]'
        return combinationUtil(arr, data, 0, n-1, 0 , target);
    }
  
  static boolean combinationUtil(int arr[], int data[], int start, int end, int index , int target) {
      int r = arr.length -1;
        // Current combination is ready to be printed, print it
        if (index == r) {
            for (int j=0; j<r; j++) {
                int res = target % data[j];
                if(res == 0) {
                  return true;
                }
            }
            
        }
 
        for (int i=start; i<=end && end-i+1 >= r-index; i++) {
            data[index] = arr[i];
            boolean resr = combinationUtil(arr, data, i+1, end, index+1, target);
          if(resr) {
              return true;
          }
        }
         return false;
    }
  
  

  
  public void run() {
 
    int arr_1[] = {5, 10, 25, 100, 200};
    int arr_2[] = {4, 17, 29};
    canGetExactChange(94, arr_1);
   // canGetExactChange(94, arr_2);
  
  }
  
  public static void main(String[] args) {
    new CurrencyExchange().run();
  }
}

