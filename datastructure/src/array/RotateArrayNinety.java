package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RotateArrayNinety {

    private static void rotateArray(List<List<Integer>> input) {
            for(int i = 0 ; i < input.size() ; i++) {
                for (int j = i ; j < input.size() ; j++) {
                    int temp = input.get(i).get(j);
                    input.get(i).set(j, input.get(j).get(i));
                    input.get(j).set(i, temp);
                }
            }
                for(int k = 0 ; k < input.size() ; k++) {
                    Collections.reverse(input.get(k));
                }
            }
    

    
    public static void main (String [] args) {
        List<Integer>  element1 = new ArrayList<>();
        element1.add(1);
        element1.add(2);
        element1.add(3);
        List<Integer>  element2 = new ArrayList<>();
        element2.add(4);
        element2.add(5);
        element2.add(6);
        List<Integer>  element3 = new ArrayList<>();
        element3.add(7);
        element3.add(8);
        element3.add(9);
        List<List<Integer>> data = new ArrayList<>();
        data.add(element1);
        data.add(element2);
        data.add(element3);
        rotateArray(data);
    }
    
}
