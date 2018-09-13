##Link
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
## Input
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.


https://github.com/shankarrajan/interview/blob/master/leetcode/images/listwithrandompointer.gif

##Edge Cases
- Linked list pointing to itself. 
- Linked list with size greater than 0
##Questions/Assumptions
##Code flow
set current = head;

- For each node in the list
    - create a node and insert between it and the next node. 
    eg. A-> A'-> B-> B' -> null
- current = head;    
- For each node in the list    
    - set current.next.random = current.random.next;    
- For each node in the list
    - Separate the original list from the new list;

## Pseudo code
Linked


## Test Input (To be ignored)



## Code
```java


 class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 };
 

public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode current = head;

        while (current !=  null){
            /*Store the next pointer of the current value*/
            RandomListNode currentNext = current.next;
            /*Create a duplicate of current value and link it between current and currentNext*/
            RandomListNode temp = new RandomListNode(current.label);
            temp.next = currentNext;
            current.next= temp;
            current = currentNext;
        }
        current = head;
        while(current != null){
            if(current.random!= null ){
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        current = head;
        RandomListNode pseudoHead = new RandomListNode(0);
        
        RandomListNode duplicate = pseudoHead;
        while (current != null){
            
            RandomListNode next = current.next.next;
            
            RandomListNode copy = current.next;
            duplicate.next = copy;
            duplicate= copy;
            
            current.next= next;
            current = next;
        }
        return pseudoHead.next;
    }

```