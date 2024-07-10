package array;

import java.util.Arrays;

public class MoveZeroToEndOfArray {

    public static void main(String[] args) {
        int arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
        myMethodJunk(arr);
        moreEfficient(arr);
    }

    private static void myMethodJunk(int [] arr) {
        int nonZeroPointer = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] == 0) {
                for(int j = nonZeroPointer+1 ; j < arr.length ; j++) {
                    if(arr[j] !=0) {
                        arr[i] = arr[j];
                        arr[j] = 0;
                        nonZeroPointer++;
                        break;
                    }
                }
            } else {
                nonZeroPointer = i ;
            }
        }

        Arrays.stream(arr).forEach(System.out::print);
        System.out.println("");
    } 

    private static void moreEfficient(int [] arr) {
        int count = 0;

        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] !=0) {
                arr[count++] = arr[i];
            }
        }
        while (count < arr.length) {
            arr[count++] = 0 ;
        }
        Arrays.stream(arr).forEach(System.out::print);
    }
}
