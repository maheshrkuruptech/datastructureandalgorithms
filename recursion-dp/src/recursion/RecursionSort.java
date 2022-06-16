package recursion;

import java.util.Arrays;

/**
 * This is just to get familiarized with the techniques. Use heap or merge. \
 */
public class RecursionSort {
    public static void main(String[] args) {
        int [] input = new int[]{1,5,3,2};
        sort(input);
        Arrays.stream(input).boxed().forEach(integer -> {
            System.out.println(integer);
        });
    }

    static void sort(int[]input) {
        // base condition
        if(input.length == 0 ) {
            return;
        }
        int temp =  input[input.length -1];
       sort(Arrays.copyOf(input, input.length - 1));
        magic(input , temp);
    }

    static void magic(int [] input , int element) {
            if(input == null || input[input.length -1] <= element) {
                // add to input
                return ;
            }
            // input = reduced input
            magic(input , element);

    }
}
