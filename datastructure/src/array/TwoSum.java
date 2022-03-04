package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TwoSum {

  public static void main(String[] args) {
    int [] input = new int[] {3,2,1,4,5};
    int [] result = twoSum(input , 7);
    for (int i = 0 ; i < result.length ; i++) {
      System.out.print(result[i]);
    }
  }

  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0 ; i < nums.length ; i++) {
      int complement = target - nums[i];
      if(map.containsKey(complement)) {
        return new int[] {map.get(complement) , i};
      }
      map.put(nums[i] , i);
    }
    return null;
  }

  public static int[] twoSum2D(int[] nums, int [] nums2 , int target) {
    HashSet<Integer> map = new HashSet<>();
    for(int i = 0 ; i < nums2.length ; i++) {
      int complement =    target - nums [i];
      map.add(complement);
    }
    for(int j = 0 ; j < nums.length ; j++) {
      if(map.contains(nums[j])) {

      }
    }

    return null;
  }
}
