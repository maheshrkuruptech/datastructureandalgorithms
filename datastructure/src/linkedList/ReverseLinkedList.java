package linkedList;


public class ReverseLinkedList {

  public static Node reverse(Node head) {
    if(head.next == null){
      return head;
    }
    Node newHead = reverse(head.next);
    // head.next is now the last node in the reversed list, point it back to head
    head.next.next = head;
    head.next = null;  // Set the old head's next to null to become the new tail
    return newHead;
  }

  public static void main(String[] args) {

    Node x = null;

    /* construct the first Linked List */
    x = insert(x,3);x = insert(x,4);x = insert(x,5);
    x = insert(x,7);x = insert(x,9);x = insert(x,12);
    x = insert(x,11);x = insert(x,8);
    System.out.print("Linked List : ");
    print(x);
    System.out.println();

    /* merge the 2 Linked Lists and print */
    System.out.print("Reverse Linked List : ");
    Node result = reverse(x);
    print(result);
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