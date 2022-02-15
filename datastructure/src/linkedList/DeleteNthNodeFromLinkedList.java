package linkedList;

public class DeleteNthNodeFromLinkedList {

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
    deleteFromList(x,3);

    print(x);

  }

  /**
   *
   * @param head first linkedList
   * @param position second linkedlist
   * @return result linkedlist
   *
   */
  private static void deleteFromList(Node head, int position) {
      for (int i = 0 ; i < position -1 ; i ++) {
        if( head != null)
            head = head.next;
      }
    Node next = head.next.next;
    head.next = next;

  }



}
