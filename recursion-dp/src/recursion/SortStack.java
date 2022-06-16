package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stacko = new Stack<>();
        stacko.add(5);
        stacko.add(2);
        stacko.add(3);
        stacko.add(9);
        List<Integer> ar = new ArrayList<>();
        sortStack(stacko , ar);
        System.out.println(ar);
    }
    // Note : use same recursion l;
    static void sortStack(Stack stacko , List<Integer> result) {
        if(stacko.isEmpty()) {
            return;
        }
        int data = (int)stacko.pop();
        result.add(data);
        result.sort(Integer::compareTo);
        sortStack(stacko , result);
    }
}
