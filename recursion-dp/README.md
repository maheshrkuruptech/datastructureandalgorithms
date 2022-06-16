
Recursion is top - down approach, and it usually leads to exponential time-complexity. 

Can be reduced further by memoization. This will reduce the complexity to O(n).

Then why use DP ? 

The advantage of using DP is that this will avoid the 
space complexity wrt recursion adding all those 
messages to the call stack. 

 
Input / Output method
    Decision-Making is primary.  It will auto lead to smaller input.
    Decision-Making is made based on choice.
    Decision is represented as a Recursive Tree. 
    Number of Branches in Recursive Tree is no: of choices.
        
        Code Approach : 
        
        Design a recursion tree.
        
        Write base condition first.
        
        Write rest of the program.

     
Base Condition -  Hypothesis - Induction method. (IBH) - Best for Tree/ Linked List.

    Applies when hard to put a decision tree. This method focus on just making i/p smaller. 
    
 Why hard to put a rec tree ? 
   No decision to make. We dont get any O/P from leaf node of the tree.      

Design a Hypothesis : With input , what its doing. 
Then run with a smaller input ; to confirm hypothesis. 

How to design hypothesis ? 
- Since this stage is important. We decide on what should be the method signature. 
- What all components are needed. 

Induction - Mathematical : 
Apply the hypothesis. Build the function. Pass in the input. 

Base condition : Smallest / Largest valid input.
Apply Base condition. 


Choice Diagram - DP 




