package linkedList;


public class ReverseEvenElementsLinkedList {
    

  public static void main(String[] args) {
    Node x = null;
    /* construct the first Linked List */
    x = insert(x,1); 
    x = insert(x,2);x = insert(x,4);x = insert(x,6);x = insert(x,8); 
    x = insert(x,9);x = insert(x,12); x = insert(x,16); 
    print(x); 
    System.out.println("Logic starts");
    Node result = reverseEven(x);
    System.out.print("Even list is : ");
    print(result);
  }

  static Node reverseEven(Node head) {
    if (head == null) {
        return null;
    }   
    Node temp = head;
    Node prev = null; // tracks the odd number before even to attach it.
    
    while (temp != null) {
        Node start = null, end = null;
        if (temp.data % 2 == 0) {
            start = temp;
            while (temp != null && temp.data % 2 == 0) {
                temp = temp.next;
            }
            end = temp;
            
           Node newStart = reverse(start, end);
    
            if (prev == null) { // if start was the head of the list update head with reversed even. 
                head = newStart; 
            } else {
                prev.next = newStart; // Connect the previous part of the list to the reversed sublist
            }
        } else {
            prev = temp;
            temp = temp.next;
        }
    }
    return head;
}
  private static Node reverse(Node start, Node end) {
    Node prev = end;
    Node current = start;
    while (current != end) {
        Node next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    return prev;
}

static class Node {
  int data;
  Node next;
  Node(int num) {
    data = num;
    next = null;
  }
}

/* append a node at the end of the Linked List */
static Node insert(Node head,int data) {
  if(head == null)
    head = new Node(data);
  else {
    Node temp = head;
    // Iterate to the end of linked list.
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = new Node(data);
  }
  return head;
}

/* print the Linked List */
static void print(Node head) {
if(head != null) {
  System.out.print(head.data + " ");
  print(head.next);
}
}
}
