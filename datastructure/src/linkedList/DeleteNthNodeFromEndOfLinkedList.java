package linkedList;

public class DeleteNthNodeFromEndOfLinkedList {

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


  public static void main (String[] args)
  {
    Node x = null;

    x = insert(x,3);
    x = insert(x,4);
    x = insert(x,5);
    x = insert(x,7);
    x = insert(x,9);

    System.out.print("First Linked List : ");
    print(x);
    System.out.println();

    /* merge the 2 Linked Lists and print */
    System.out.print("Result Linked List After Deletion : ");

    deleteNthFromEndOfList(x , 3);
    print(x);

  }


  /**
   * Complexity O(n)
   * @param head
   * @param position
   */
  private static void deleteNthFromEndOfList(Node head, int position) {
    Node fast = head;
    Node slow = head;
    // Advance pointer to N position
    for(int i = 0 ; i < position  ; i++ ) {
      fast = fast.next;
    }
    // Increment both pointers
    while(fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    //swap the next value
    slow.next = slow.next.next;;

  }

}
