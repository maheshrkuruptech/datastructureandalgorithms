package linkedList;

public class StackImplementation {

    public static void main(String[] args) {
    
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.printElement();
        stack.pop();
        stack.printElement();
        stack.peek();

    }

}



class Node {
    Node pointer ;
    int  data ; 
    public Node (int data , Node pointer) {
        this.data = data;
        this.pointer = pointer;
    }
    public Node() {

    }
    
}

class Stack  {
    Node top;



    public void push (int element) {
        Node topNode = top == null ? null : top;
                    Node node = new Node(element , topNode);
                    top = node ;
    }

    public void pop () {
         top = top.pointer;
    }

    public void peek() {
        System.out.println("Top element is " +top.data);
    }
    public void  printElement() {
            printRecurse(top);

    }

    private void printRecurse(Node elementNode) {
        if(elementNode !=null) {
            System.out.println(elementNode.data);
            printRecurse(elementNode.pointer);
        }
        return;
    }

}