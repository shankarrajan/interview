## Link

https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
## Input
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

https://github.com/shankarrajan/interview/blob/master/leetcode/resources/listwithrandompointer.gif

## Edge Cases
- Linked list pointing to itself. 
- Linked list with size greater than 0

## Questions/Assumptions

## Code flow
### Logic
- create a copy of each node and set it as next value for the nodes
- Set each node next random value as nodes random next value (initializes random value for each duplicate node)
- Split each node to separate list.

set current = head;

- For each node in the list
    - create a node and insert between it and the next node. 
    eg. A-> A'-> B-> B' -> null
- current = head;    
- For each node in the list    
    - set current.next.random = current.random.next;    
- For each node in the list
    - Separate the original list from the new list

## Pseudo code
set current = head
//create duplicate values and set to the current node next value 
till current not null
    duplicate = randomNode(current.value)
    duplicate.next=current.next
    current.next= duplicate
    current = current.next.next

set current = head
//assign random pointers for duplicate nodes
till current not null
    set current.next.random = current.random.next, if current.random not null

//split the original list and duplicate list

till current not null 
    split the value of duplicate and current value. 



## Test Input (To be ignored)



## Code
```java


 class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 };
 
class Solution{
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
}
```