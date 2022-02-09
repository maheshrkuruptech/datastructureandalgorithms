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



