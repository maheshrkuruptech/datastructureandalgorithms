package linkedList;


public class ReverseEvenElementsLinkedListThanksBrain {
    

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
    Node prev = head; // tracks the odd number before even to attach it.
    while (temp != null) {
       // seek to last odd
        while(temp != null && isOdd(temp.data)) {
          if(temp.next !=null && isOdd(temp.next.data)) {
             temp = temp.next; 
          } else {
             break;
          }
        }   
        // make the pointer of odd available
        prev = temp;
        if(temp !=null) {
          temp = temp.next;
          // keep a reference of first even to attach to the next odd sequence
          Node ttmp = temp;
          // seek to next odd 
          while(temp != null &&  !isOdd(temp.data)) {
            temp = temp.next; 
          }
          Node even =   reverse(ttmp);
          Node evenpointer = even;
         
           // Attach to next odd for continuity.
          while(even.next !=null) {
            even = even.next;
          }
          even.next = temp;
          // Attach to next odd for continuity ends.


          //connect with last odd. 
          if(prev == null) {
            prev = evenpointer;
          } else {
            prev.next = evenpointer;
          }
          //connect with last odd ends. 
          
          // make it start from next odd , we know ttmp points to last even from reversed.
          // since we attached next odd  to it. ttmp.next is the next odd after reversal
          
          temp = ttmp.next;
        }
    }

    return head;
  }
  public static Node reverse(Node head) {
    if(head.next == null || isOdd(head.next.data)) {
      return head;
    }
    // return the reversed Node to maintain pointer
    Node newHead = reverse(head.next);
    // head.next is now the last node in the reversed list, point it back to head
    head.next.next = head;
    head.next = null;  // Set the old head's next to null to become the new tail
    return newHead;
  }

private static boolean isOdd(int data) {
  return data%2!=0;
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
