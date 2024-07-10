package recursion.experiments;

import java.util.Stack;

public class SortAStack {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(9);
        s.push(5);
        s.push(12);
        s.push(1);
        // s.push(6);
        sort(s);
        System.out.println(s);
        
    }

     
    private static void sort (Stack<Integer> st) {
        if(st.size() <= 1 ) {
            return;
        }
        int temp = st.pop();
        sort(st);
        insert(st, temp);
    }

    private static void insert (Stack<Integer> st , int val) {
        if(st.size() == 0 || st.peek() <= val) {
            st.push(val);
            return;
        }
         int temp = st.pop();
         insert(st, val);
         st.push(temp);
    }

  
}
