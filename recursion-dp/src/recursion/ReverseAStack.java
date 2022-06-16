package recursion;

import java.util.Stack;

public class ReverseAStack {
    public static void main(String[] args) {
        Stack<Integer> stacko = new Stack<>();
        stacko.add(5);
        stacko.add(4);
        stacko.add(3);
        stacko.add(2);
        System.out.println(stacko);
        reverse(stacko);
        System.out.println(stacko);
    }

    static void reverse(Stack<Integer> input) {
        if(input.isEmpty()) {
            return;
        }
        int data = input.pop();
        reverse(input);
        insert(input , data);
    }

    static void insert(Stack<Integer> input , int element) {
        if(input.isEmpty()) {
            input.add(element);
            return;
        }
        int data = input.pop();
        insert(input , element);
        input.add(data);
    }
}
