package knapsack.zeroone;

import java.util.Arrays;

/**
 *
 * This comes in two variations.
 *
 * 1. Subset sum with given difference : In this case , s1 - s2  = k ; s1 + s2 = sum of array . s1 = k + Sum of array /2
 *   ie , subset sum -> target ==>  k + Sum of array /2
 *
 * 2. Target Sum Problem : Given an array , given the flexibility to add + or - to each element ; get a target.
 *      Here , it's the same problem as above ; subset with given difference ; Which is solved By Subset sum itself.
 *
 */
public class CountOfSubSetWithGivenSum {

    public static void main(String[] args) {
        int [] input = new int[] {2,3,5,6,8,10,7};
        System.out.println(findSubArrayWithSumDP(input , 10));
    }

    static int findSubArrayWithSumDP(int[] input , int target) {
        if(target == 0 ) {
            return 1;
        }
        if(input.length == 0) {
            return 0;
        }
        if(target - input[input.length -1] >=0)
            return findSubArrayWithSumDP(Arrays.copyOf(input , input.length -1) , target - input[input.length -1])
                    + findSubArrayWithSumDP(Arrays.copyOf(input , input.length -1) , target);

        return  findSubArrayWithSumDP(Arrays.copyOf(input , input.length -1) , target);

    }
}
