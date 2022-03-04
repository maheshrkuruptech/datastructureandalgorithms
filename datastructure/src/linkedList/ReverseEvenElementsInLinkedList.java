package linkedList;


public class ReverseEvenElementsInLinkedList {
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

    static Node reverse(Node head) {
      // Write your code here
      Node temp = head;
      Node prev  = null;

      while(temp !=null) {
        Node markerNode;
        if(temp.data % 2 == 0) {
          int index = 0;
          markerNode = temp;
          // Save all the nodes to reverse.
          while( markerNode != null && markerNode.data % 2 == 0 ) {
            index++;
            markerNode = markerNode.next;
          }
          Node before_even_node = prev;
          Node evenNode = temp;
          Node prevLocal = null;
          Node next;

          while(temp !=null && index > 0 ) {
            next  = temp.next;
            temp.next = prevLocal;
            prevLocal = temp;
            temp = next;
            index --;
          }
          before_even_node.next = prevLocal;
          evenNode.next = markerNode;
        } else {
          prev = temp;
          temp = temp.next;
        }
      }
      return head;
    }

  public static void main(String[] args) {

    Node x = null, y = null;

    /* construct the first Linked List */
    x = insert(x,1);
    x = insert(x,2);
    x = insert(x,8);
    x = insert(x,9);
    x = insert(x,12);
    x = insert(x,16);


    System.out.print("Input Linked List : ");
    print(x);
    System.out.println();


    /* merge the 2 Linked Lists and print */
    System.out.print("Merged Linked List in Sorted Order : ");
    Node result = reverse(x);
    print(result);
  }

}
