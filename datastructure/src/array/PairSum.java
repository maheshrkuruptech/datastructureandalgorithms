package array;

import java.util.HashSet;


public class PairSum {
    int numberOfWays(int[] arr, int k) {
        int count = 0 ;
        HashSet<String> pairIndex = new HashSet<>();
         for(int i = 0 ; i < arr.length ; i++) {
           int j = arr.length -1 ;  
           while(j > i) {
                if(arr[i] + arr[j] == k) {
                    int memoLow = Math.min(i ,j);
                    int memoHigh = Math.max(i,j);
                  if(! pairIndex.contains(memoLow+"-"+memoHigh)) {
                      count++;
                      pairIndex.add(memoLow+"-"+memoHigh);
                  } 
                }
                  j--;
            }
         }
            return count;        
      }
}
