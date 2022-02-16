package linkedList;


public class UnionAndIntersectionOfLinkedList {

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
    System.out.print("Intersection of Linked List : ");
    intersection(x , y);
    System.out.println();
    System.out.print("Union of Linked List : ");
    union(x,y);
    // implement union here
    // implement intersection here.


  }

  public static void intersection(Node x , Node y) {
    Node result = null;
      while(x != null) {
         if(isPresent(x.data , y)){
            result = insert(result , x.data);
         }
         x = x.next;
      }

      print(result);
  }


  public static void union(Node x , Node y) {
    Node result  = null;
    while(x !=null) {
      result = insert(result , x.data);
      x = x.next;
    }

    while(y !=null) {
      if(!isPresent(y.data , result)){
        result = insert(result , y.data);
      }
      y = y.next;
    }

    print(result);
  }

  static  boolean isPresent(int data , Node head) {
    Node t = head;
    while (t != null) {
      if (t.data == data)
        return true;
      t = t.next;
    }
    return false;
  }


}
