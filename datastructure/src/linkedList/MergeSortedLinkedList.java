package linkedList;

public class MergeSortedLinkedList {

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
    print(sortedMerge(x,y));

  }
// check  next
  /**
   *
   * @param x first linkedList
   * @param y second linkedlist
   * @return result linkedlist
   *
   */
  private static Node sortedMerge(Node x, Node y) {

    if(x == null) {
      return x;
    }

    if(y == null) {
      return y;
    }

    if(x.data < y.data) {
      x.next = sortedMerge(x.next , y);
        return x;
    } else {
      if(x.next !=null && x.data == y.data) {
        y.next = sortedMerge(y.next , x.next);
        return y;
      }

      y.next = sortedMerge(y.next , x);
        return y;
    }
  }

}
