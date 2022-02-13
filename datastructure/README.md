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
Deletion and Insertion time complexity is O(1)

##### DisAdvantage
Extra memory to store pointers.
Time to traverse wrt  Complexity is O(n).
Binary Search is not possible.
Random access of memory is not possible. 

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
    ```
    O(n) vs O(1)
    ```
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
4. Balance of parentheses ,by compiler
5. Infix to Postfix/prefix.
6. Topology Sort  
7. Tower of Hanoi

