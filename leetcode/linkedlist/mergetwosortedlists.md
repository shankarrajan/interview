## Link

https://leetcode.com/problems/merge-two-sorted-lists/

## Input
```
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
```

## Edge Cases
One of it is null

## Questions/Assumptions

## Code flow
### Logic
- while list1 not null or list2 not null
    if list1 not null, get its value
        set result.next=list2, break
    if list2 not null, get its value
        set result.next= list1, break
    if list1.value >list2.value
        set it to result, advance list1
    else 
        set it to result, advance list2

## Pseudo code
```
result = new node();
dummy = result;
while list1 != null or list2!=null
    if list1!=null
        value1 = list1.value
    else
        result.next= list2
        break
    if list2!=null
        value2 = list2.value
    else
        result.next= list1
        break 
    if(value1>value2)
        outputNode = new node(value1)
        result.next = outputNode
        result = result.next
        list1 = list1.next
    else
        outputNode = new node(value2)
        result.next = outputNode
        result = result.next
        list2 = list2.next     
```


## Test Input (To be ignored)


## Tags
LinkedList 
## Code
```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        int value1=0; 
        int value2= 0;
        while (l1 != null || l2!=null){
            if (l1!=null){
                value1 = l1.val;
                }
            else{
                result.next= l2;
                break;
                }
            if (l2!=null){
                value2 = l2.val;
                }
            else{
                result.next= l1;
                break;
                }
            if(value1< value2){
                ListNode outputNode = new ListNode(value1);
                result.next = outputNode;
                result = result.next;
                l1 = l1.next;
                }
            else{
                ListNode outputNode = new ListNode(value2);
                result.next = outputNode;
                result = result.next;
                l2 = l2.next;
            } 
        }
        return dummy.next;
    }
}


```