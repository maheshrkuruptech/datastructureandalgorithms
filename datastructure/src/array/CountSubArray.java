package array;
public class CountSubArray {
    public static void main(String[] args) {
        int [] input = new int[] {3, 4, 1, 6, 2};
        int [] input2 = new int[] {2, 4, 7, 1, 5, 3};
        countSubarrays(input);
        countSubarrays(input2);
    }

    static int[] countSubarrays(int[] arr) {
      
    // Write your code here
    int [] res = new int[arr.length];
    for(int i = 0 ; i < arr.length ; i++) {
        int currentStreak = 1;
        for(int j = i+1 ; j < arr.length; j++) {
          if(arr[j] < arr[i] ) {
             currentStreak++;
          } else {
            break;
          }
        }
        
        int counter = 0;
        int maxIndex = 0;
        boolean completed = false;
        while(counter < i  || completed) {
            if(arr[counter] > arr[i] ) {
                maxIndex = counter;
            }
            counter++; 
         }
          if(maxIndex == 0) {
            currentStreak+= counter;
          } else if(maxIndex < i -1){
             currentStreak+= (i -1 - maxIndex);
          }
          
          res[i] = currentStreak;
        }
          return res;
      }
}
