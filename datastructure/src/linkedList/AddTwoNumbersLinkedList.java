package linkedList;


public class AddTwoNumbersLinkedList {

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

    public static  Node addTwoNumbers(Node A, Node B) {
        int carry = 0;
        Node head = null;
        Node node = null;
        while(A != null || B != null || carry > 0) {
            int valA = A == null ? 0 : A.data;
            int valB = B == null ? 0 : B.data;
            
            int sum = valA + valB + carry;
            Node temp = new Node(sum % 10);
            if(head == null) {
                head = temp;
                node = head;
            } else {
                node.next = temp;
                node = node.next;
            }
             carry = sum/ 10;
          if (A != null) {
            A = A.next;
          }
          if (B != null) {
            B = B.next;
          }
        }
        return head;
    }

  public static void main(String[] args) {

    Node x = null, y = null;

    /* construct the first Linked List */
    x = insert(x,3);
    x = insert(x,4);
    x = insert(x,5);
    x = insert(x,7);
    x = insert(x,9);

    System.out.print("First Linked List : ");
    print(x);
    System.out.println();

    /* construct the second Linked List */
    y = insert(y,1);
    y = insert(y,2);
    y = insert(y,5);
    y = insert(y,6);
    y = insert(y,8);

    System.out.print("Second Linked List : ");
    print(y);
    System.out.println();

    /* merge the 2 Linked Lists and print */
    System.out.print("Merged Linked List in Sorted Order : ");
    Node result = addTwoNumbers(x , y);
    print(result);
  }
}