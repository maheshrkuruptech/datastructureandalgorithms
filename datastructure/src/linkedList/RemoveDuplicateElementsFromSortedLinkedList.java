package linkedList;



public class RemoveDuplicateElementsFromSortedLinkedList {
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
  static Node delete(Node head) {

      Node temp = head;
      // Iterate to the end of linked list.
      while (temp.next != null && temp.next.next != null) {
        // same logic compares with next
        if(temp.next.data == temp.next.next.data) {
          temp.next =  temp.next.next;
        } else {
          temp = temp.next;
        }
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


  public static void main(String[] args) {
    Node x = null;

    /* construct the first Linked List */
    x = insert(x,3);
    x = insert(x,4);
    x = insert(x,5);
    x = insert(x,5);
    x = insert(x,7);
    x = insert(x,9);

    x = insert(x,12);

    System.out.print("First Linked List : ");
    print(x);
    x = delete(x);
    System.out.println();
    print(x);
  }
}
