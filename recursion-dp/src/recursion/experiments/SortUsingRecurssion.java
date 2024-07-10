package recursion.experiments;

import java.util.Arrays;

public class SortUsingRecurssion {

    public static void main(String[] args) {
        int [ ] input = new int[] {1,4,6,7,2};
        sort(input);
        Arrays.stream(input).forEach(System.out::print);
    }

    private static void sort(int [] input) { 
        if(input.length <= 1) {
                return;
        }
        int temp = input[input.length -1];
        sort(Arrays.copyOf(input, input.length -1));
        insert(input, temp);
    }

    private static void insert(int [] input , int val)  {
        // need more of array copy here ! which is less efficient. 
        // Keeping it for reference. but a good way to think recurssion 
        // using Base condition , Hypothesis and Induction
        if(input.length ==  0 || input[input.length -1] <=val) {
             input[input.length] = val;
                return;
        }
        int temp = input[input.length -1];

        insert(Arrays.copyOf(input, input.length -1) , temp);
        input[input.length] = temp;
        return;
    }
 }
