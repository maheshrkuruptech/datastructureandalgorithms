# Why Sorting Arrays ? 

If writing an array search method on an unsorted array, the sequential access costs time of O(n)

If the array is sorted , the complexity will come down (eg:  Binary Search) to O(log n).

But however the array needs to be sorted.


## Types of Sort 

### Selection Sort
    Find the smallest item in an array
    Swap that item with the first item in the array
    Continue with the next items in the array until all have been sorted.
#### When to use 
Prefer when memory is a constraint. When the array is smaller. 
Note : It's not a stable sorting algorithm

Time Complexity : 
Space Complexity : 

### Insertion Sort
    The first element is sorted.
    Compare the second element with the first.
    if it's smaller, swap otherwise stay the same
    Compare the third element with the second.
    if it's smaller, swap, compare against the first
    otherwise, stay the same
    Continue until the entire array has been sorted.
#### When to use
1. Stable sorting (preserve the order of duplicate keys) is necessary.
2. Array is almost sorted in a big array.

Time Complexity : 
Space Complexity : 
### Quick Sort 
It's a divide and conquer Algorithm.  It picks an element as pivot and partitions the given array 
around the picked pivot. 
#### Concept :  
An element is in sorted position if all elements left to that  is less than the element and 
all to the right is greater than the element. This is done by partitioning wrt a pivot element.

```
    Pick an element as pivot. 

    From the pivot , keep a pointer towards end . One from end to beginning. 

        When value at initial pointer gt pivot , stop.
        Continue with other pointer until find one lt pivot.

        Swap elements and move until low pointer and high pointer cross. 
        That position is partition. 

        Swap that position element with pivot. 
        
        Repeat it for the left and right of pivot by picking a pivot.

```

Time Complexity : 
Space Complexity: 


### Heap Sort
Heap is a Tree representation. Since its tree , the insertion , deletion can 
be done on a built heap in O(log n) . But heap creation itself will be O(n).

#### Pseudo Code for Sorting

```
Generate a Heap for n elements O(nlog n)
Remove the elements from top and keep it at the end of Heap. O(nlog n) 
```

##### Generate a Heap (Heapify)

```
// For each root node  from the leaf - 1 node 
(int) Math.floor(input.length /2);
for(int i = rootIndex ; i  >= 0 ; i--) {
        heapify(input , arrayLength , i);
}

heapify () {
    Find greatest of root , left or right. 
    Swap the element if root is small. 
    call heapify with root  as the swapped child
}
```

##### Remove elements from top

```
 Start from top , ie end of the Heap , swap element to the last. 
 Reduce the arrayLength and call Heapify
```


### Merge Sort

#### N-way merge Sort - Iterative Process
Usually done to merge multiple arrays , where each of the arrays are already sorted
This can also be used to sort an array , considering each element is an array with 1 element. 

Approach:

        Split to  (array length / array length) arrays  and sort;
        Combine (array length / array length) * 2 arrays and sort
        Repeat until the multiple exceeds the array length 
    

#### Merge Sort - Recursion Process