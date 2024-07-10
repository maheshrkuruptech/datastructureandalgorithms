package recursion.experiments;

import java.util.Stack;

public class RemoveMiddleElementStack {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);s.push(3);s.push(4);
        s.push(5);
        
        s.push(6);
        //removeMid(s , s.size()/2+1); 
        removeMidMah(s, s.size());
        System.out.println(s);
    }

    private static void removeMid (Stack<Integer> st , int l) {
        if(l == 1) {
            st.pop();
            return;
        }
            int th = st.pop(); 
            removeMid(st , l-1);
            st.add(th);
    }

    private static void removeMidMah (Stack<Integer> st , int l) {
        if(st.size() == l/2) {
            st.pop();
            return;
        }
            int th = st.pop(); 
            removeMidMah(st , l);
            st.add(th);
    }
}
