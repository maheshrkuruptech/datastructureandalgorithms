package array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
  public static void main(String[] args) {
    summaryRanges(new int[] {0,1,2,4,5,7});
    summaryRanges(new int[] {0,2,3,4,6,8,9});
  }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int min = 0 ;
        int max = 0;    
        for(int i = 1 ; i < nums.length ; i++) {
                if(nums[i] - nums[i-1] == 1  ) {
                       max++; 
                } else {
                    if(min == max) {
                        result.add(String.valueOf(nums[min]));
                    } else {
                        result.add(nums[min]+"->"+nums[max]);
                    }
                  if (i == nums.length -1) {
                    result.add(String.valueOf(nums[i]));
                  }
                    min = i;
                    max = i;
                }
            }
        return result;
    }
}