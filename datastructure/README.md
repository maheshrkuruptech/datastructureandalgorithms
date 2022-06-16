
## Linear Data Structure

### Arrays
Arrays are fixed size sequenced collection of same datatype. 
Arrays allocate memory at intialization time ; though there is a concept of dynamic array. 
  ```
    int [] test = new int[3];
```  
Consecutive memory block will be allocated during initialization. 

**How constant time access is achieved in array lookup ? **

Say base address is 100 (though the address is HEX). int usually takes 4 bytes. 
So allocated memory will be from 100 - 112. When an element is accessed , the fetch a[n]
will use the formulae to find the address by (base + (size of datatype * n)) . 
Access elements will have the complexity of O(1).  Array follows random access method.

#### Advantage
     Access elements with the time complexity of O(1)
#### Drawback
    Wasting space with static declaration ; since the size cant be extended.

    Runtime want to extend the array. Then Memory manager has to copy the initial array , delete and then allocate the 
    needed to become contiguous for random access with complexity O(n).

#### Insert data at certain position. 
Time Complexity / Space Complexity Depends on the position at which the data needs to be inserted and if the 
array is sorted or not. Generalized as O(n).
##### In case of unsorted array
```     
for(int i = size  -1 ;  i < position  - 1 ; i--)
a[i +1 ] = a [i]
```

```
a[size] = a[pos]
a[pos] = 1
```

Here its theta(1).

##### In case of sorted array
Binary Search ; find the index , shift the elements from that to the end ;  then update the data with O(n)

#### Delete data at certain position
[1,2,3,4] ; pos = 2
```     
for(int i = position -1 ;  i < size - 1 ; i++)
a[i] = a [i + 1]
```
```
a[pos] = i 
a[size -1] = 0

```


### Linked List
Solves the drawback of array , 
1. wastage of memory due to initialization at compile time. 
2. Extending the size is overhead , since this involves allocating fresh memory , 
   copying all from previous memory block.

How Linked List is  solving the problem.
In Linked List , the data is not stored in consecutive location.

This leads to the question on accessing next element in the list. 
This is solved by adding the address of next value. Extra 4 byte is stored for the address of next item.
In 64 bit compiler its going to take 8 bytes for the address.
The trade-off here is the extra memory. [Double for integer ; 4 times for char]
Last element of the linked list will store the address to next element as null. 

In Linked List , only sequential access is possible ; not random access. 

Deletion and Insertion is simpler in this data structure. Add elements involves ; only swapping pointers. 

##### Advantage
Wastage of memory due to initialization at compile time is solved.
Its of dynamic size. 
Deletion and Insertion time complexity is O(1) ?? :D

##### DisAdvantage
Extra memory to store pointers.
Time to traverse wrt  Complexity is O(n).
Binary Search is not possible.
Random access of memory is not possible. 

**Note** : Always keep the head point to the initial element. Insertion or deletion to use
temp node ; assign head to temp and do the operation so that head points to the initial location.
##### Types
 Singly LinkedList : Simplest , only data and pointer to its next node.
 Rest are enhancements on LinkedList.    
 Doubly LinkedList : Data and pointer to previous and next node. 
 Circular LinkedList : Is a variation of singly linked list ; with last node having address of first node. 
 Doubly Circular LinkedList: first node previous node will be last node address; last node points to first node address.
##### 
Applications:
1. Browser back/forward button
2. Playlist (next / previous)
3. Undo / Redo
 
#### Comparison of Array vs LinkedList
###### Cost of accessing elements
    O(n) vs O(1)    
    
###### Memory Requirement 
    More in linked list with pointer
###### Memory Utilization
    Effective in linked list.
###### Cost of Insertion/Deletion Array Vs Linked List
  1. In the beginning   O(n)   - O(1)
  2. In the end - O(1) - O(n)
  3. In the middle - O(n) - O(n)

### Stack
Is a linear data structure of similar datatype. It's an ordered 
list follows a rule Insertion(push) and Deletion(pop) is possible only from one end.
Read without push or pop is `peek / pop`. 
Follows `LIFO` . eg: CD stand.
Stack can be implemented using array(static) and linked list(dynamic).

In static implementation , if elements push > array.size - 1 ; Overflow condition.

Time complexity for searching : O(n) ; Time Complexity for Insertion / Deletion O(1) 

Application :
1. Reverse a string. 
2. Undo mechanism
3. Recursion function call
4. Balance of parentheses ,by a compiler . 
   All opening can go in a stack. Take each closed and pop from stack to compare.
5. Infix to Postfix/prefix.
6. Topology Sort  
7. Tower of Hanoi

Implementing using Array will be straight-forward
But implementing with LinkedList , should make the operations on the first node so that 
the O(1) can be maintained. 

Pseudo Code for Stack Implementation using Linked List
```
Keep a global reference of head using along with the Node. 
 Node {
    int data;
    Node next;
 }
 Node top;
push () {
    Node n  = new Node();
    n.data = x;
    n.next = top;
    top = n;
}
public void peek() {
        top  = top.data;
}
public void pop() {
        top  = top.next;
}
```
Pseudo Code for Stack Implementation using Array
```
int top; // initialize to -1 in constructor.
int a[] = new int[MAX];

push() {
a[++top] = x;
}
int pop () {
return a[top--];
}

int peek() {
return a[top];
}
```


### Binary Tree

Height of binary tree : log(n)
Few definitions : 

Complete Binary Tree: - At the last level , all the elements are filled until the leaf node. 
And the elements in a leaf are filled from left to right without any missing element.

Full Binary Tree: Binary tree with max no of nodes ie ,  2^n - 1 no of elements.

#### Binary Tree Array Representation. 
Index starts with 1 for easy representation. Elements are formed level by level.
Relationship is formed by following formulae. For node 

```
Parent = i/2 (floor value) 
Left Child = 2*i
Right Child = 2*i + 1
``` 
If any elements are not present , leave blank(Dont fill to maintain the relationship)


### Heap
Heap is a specialized complete binary tree satisfying the heap property. 

Max Heap :  Parent node must be greatest among the keys present at all of its children recursively.

Min Heap : Parent node must be lowest among the keys present at all of its children recursively.

##### Insert Operation in Heap
**Insert should always happen in the leaf** last free space , filling left to right. 
(Making it a complete binary tree after insertion , maintaining the  Heap property) and 
then **move the elements upward**  until the child elements are less or greater(depends on the Heap
property) than the inserted element.

Time Complexity : O(1)  - O(log n)

##### Delete Operation in Max Heap
**Delete the root element** . To maintain the complete binary tree structure , then 
last element from the complete tree (right most leaf) will take the place of root element. 
And adjust from root to leaf. 

Time Complexity : O(1)  - O(log n)


Delete operation will free up a space in the array and if we keep filling the elements in 
the empty space the resultant array is sorted. This is the basic technique of Heap Sort. 

##### Procedure
```
Create a heap - Following the insert operation process maintaining the heap prop: - O(nlogn)
Delete all the elements from heap - O(nlogn)
```
**Note :** Use Max Heap to get array sorted in ascending order. Min Heap for desc order. 

Heap Sort Complexity : O(nlogn)

#### Heapify
Process of creating a heap data structure for input elements. This could be a max heap
or min heap.  This is done by looking node downwards.

Heapify Time Complexity : O(n) ; Achieved by the process of siftDown.

Procedure.
```
Check all the nodes starting from right leaf node , 
if it has any children node. 
Check if its child nodes maintaining the min/max heap property. 
If not swap recursively until the property is maintained. 
```  

#### Priority Queue
Elements are Inserted and Deleted based on the priority. Not a FIFO queue.

Delete , always get the highest priority element. The priority could be the number itself. 
     
Small number , High priority (**Min Heap**) OR Large number High priority(**Max Heap**).

If implement priority queue using Array, delete is O(n) ; even if sorted.

With Heap , since its already sorted , O(log n).

## Non Linear Data Structure
Data is in the form of hierarchy. 
### Graph

### Tree
Used to represent data in hierarchical relationship between them. 

Tree has different meaning in the context it's using. 

In Graph Theory , Tree is an un-directed graph , connected and acyclic.

In Data Structure ,A collection of entities linked together to form a hierarchy. 
It follows top-down approach.  Elements are Roots and Nodes.

Depth of a node : No: of edges  from root until the node

Height of node  : Longest path from that node to leaf

Degree of a node :  No : of child elements for the node

Degree of a tree : Max degree of all nodes

Internal Node : ALl nodes except the leaf node. 
    
#### Binary Tree
Trees with Utmost 2 child nodes.
Max  no of nodes at any  level n = 2^n

Max no of nodes of height h = 2^h+1 - 1 


###### Types of B-tree
    Binary Search Tree
        Right is always greater than Left. 
        Dont insert duplicates in Binary Search Tree
        Depends on the key , the search time varies from
        O(logn) - O(n).
    
    AVL Tree
        AVL Tree is a height balanced binary search tree
        Balance Factor = height of left - right tree. ;height in  {-1,0,1}
        then , balance factor should be {hl - hr < = 1}
        If not in any of this height ; apply rotation to make it balanced. 
        
        eg: Left left imbalance(left heavy; positive 
            value for the balance factor. is taken care by LL rotation.
            Then pull the pulley to the right. (Always to the opp: side)
            Left Right imbalance(left heavy , right also heavy)
                Fix Right - Pull  to left
                Fix Left - Pull to right
            Right Right Imbalance
                Pull to left
            Right Left Imbalance
                Fix left -  pull to right
                Fix right - pull to left

        
##### Full / Proper / Strict
Each node should have either 0 or 2 children.
##### Complete
All levels are filled except the leaf node and the nodes should be 
as left as possible. 
###### Perfect
All leaf nodes are full.
###### Degenerate / Skewed 
Each internal node has only one child. 

|Tree | Max Nodes  | Min Nodes |
| --- | ------------- | ------------- |
| Binary | 2^h+1 - 1   | h +1 |
| Full| 2^h+1 - 1   | 2h+1  |
| Complete| 2^h+1 - 1   | 2h  |

|Tree | Min Height  | Max Height |
| --- | ------------- | ------------- |
| Binary | log(n+1) - 1   | n-1  |
| Full| log(n+1) - 1   | (n + 1) / 2  |
| Complete| log(n+1) - 1   | log n  |


##### Tree Traversal
###### Depth First Search
|Type | Strategy  |
| --- | ------------- | 
| PreOrder | Root , Left , Right   |
| PostOrder| Left , Right , Root|
| InOrder| Left , Root , Right   |

