package recursion.experiments;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        System.out.println(s);
        reverse(s);
        System.out.println(s);
    }

    private static void reverse(Stack<Integer> stack) {
        if(stack.size() == 0) {
            System.out.println("Reached 0");
            return;
        }
        int lava = stack.pop();
        reverse(stack);
       addToBottom(stack , lava);

    }

    private static void addToBottom(Stack<Integer> stack , int lava)  {
        if(stack.size() == 0) {
            System.out.println("Reached 0");
            stack.add(lava);
            return;
        }
        int do1 = stack.pop();
         
       addToBottom(stack , lava);
       stack.add(do1);
    }

   
}
