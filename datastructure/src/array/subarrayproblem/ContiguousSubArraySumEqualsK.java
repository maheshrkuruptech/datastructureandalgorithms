package array.subarrayproblem;

import java.util.HashMap;

public class ContiguousSubArraySumEqualsK {

  public static void main(String[] args) {
    System.out.println(subarraySum(new int[] {0 , 1,2,3, 2 , 4} , 6));
  }

  /**
   * This methods solves the problem by cumulative sum method with complexity O(n)
   * @param nums
   * @param k
   * @return
   */

    public static  int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
          if (map.containsKey(sum - k)) {
            count += map.get(sum - k);
          }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}