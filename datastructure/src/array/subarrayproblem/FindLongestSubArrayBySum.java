package array.subarrayproblem;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSubArrayBySum {

  public static void findMaxLenSubarray(int[] nums, int S)
  {
    Map<Integer, Integer> map = new HashMap<>();

    map.put(0, -1);

    int target = 0;

    int len = 0;

    int ending_index = -1;

    // traverse the given array
    for (int i = 0; i < nums.length; i++)  {
      target += nums[i];
      map.putIfAbsent(target, i);
      if (map.containsKey(target - S) && len < i - map.get(target - S)) {
        len = i - map.get(target - S);
        ending_index = i;
      }
    }
    System.out.println("[" + (ending_index - len + 1) + ", " + ending_index + "]");
  }

  public static void main (String[] args) {
    int[] nums = { 5, 6, -5, 5, 3, 5, 3, -2, 0 };
    int target = 8;
    findMaxLenSubarray(nums, target);
    findMaxLenSubarray(new int[] {-2,11,8,9,1,2,3,6,5,7} , 12);
  }
}