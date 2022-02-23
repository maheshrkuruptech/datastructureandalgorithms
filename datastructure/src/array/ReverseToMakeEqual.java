package array;

import java.util.HashMap;
import java.util.Map;

public class ReverseToMakeEqual {
    

    boolean areTheyEqual(int[] array_a, int[] array_b) {
        // Write your code here
          HashMap<Integer , Integer> mapping = new HashMap<>();
         for(int i = 0 ; i < array_a.length ; i++) {
              if(mapping.containsKey(array_a[i])) {
                mapping.put(array_a[i] , mapping.get(array_a[i])+1);
              }   
              mapping.put(array_a[i] , 1);
         }
        
        for(int i = 0 ; i < array_b.length ; i++) {
              if(mapping.containsKey(array_b[i])) {
                mapping.put(array_b[i] , mapping.get(array_b[i])-1);
              }   
         }
         for (Map.Entry<Integer,Integer> entry : mapping.entrySet()) {
               if(entry.getValue() == null || entry.getValue() !=  0) {
                 return false;
               }
        }
        
      return true;
        
      }
}
