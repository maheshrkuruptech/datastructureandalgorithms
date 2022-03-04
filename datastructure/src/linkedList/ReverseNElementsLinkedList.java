package linkedList;


public class ReverseNElementsLinkedList {

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


  public static Node reverseBetween(Node head, int m, int n) {
    if(head == null || head.next == null){
      return head;
    }
    Node dummy = new Node(-1);
    dummy.next = head;
    Node current = dummy, next = null, previous = null;
    int count = 0;
    while(current != null && count < m){
      previous = current;
      current = current.next;
      count++;
    }
    Node before_m = previous, mth_node= current;
    previous = null;
    while(current != null && count <= n){
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
      count++;
    }
    before_m.next = previous;
    mth_node.next = next;
    if(m == 1){
      return previous;
    }
    return head;
  }

  public static void main(String[] args) {

    Node x = null;

    /* construct the first Linked List */
    x = insert(x,3);
    x = insert(x,4);
    x = insert(x,5);
    x = insert(x,7);
    x = insert(x,9);
    x = insert(x,12);
    x = insert(x,11);
    x = insert(x,8);
    System.out.print("Linked List : ");
    print(x);
    System.out.println();

    /* merge the 2 Linked Lists and print */
    System.out.print("Reverse Linked List : ");
    Node result = reverseBetween(x , 2 , 8);
    print(result);
  }
}