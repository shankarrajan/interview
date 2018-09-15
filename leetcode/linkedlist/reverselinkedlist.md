## Link

https://leetcode.com/problems/reverse-linked-list/description/
## Input
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL


## Edge Cases
- no value in linked list


## Questions/Assumptions
- circular linked list (Clear with interviewer)



### Logic
- get the current node 
if  null or next element null, return current  
else 
    temp as reverse(current)
    swap current and next element
    return temp

## Code flow



## Pseudo code
reverse(current)
    if current = null
        return null
    if current.next=null
        return current
    temp = reverse(current.next)
    current.next.next = current
    current.next = null
    return temp

## Test Input (To be ignored)
fn:reverse(A) current=A
    temp = reverse(B) 
    
        fn:reverse(B) current=B
            temp = reverse(C)
            
                fn:reverse(C) current=C
                    current.next=null
                    return current

        temp=C
        B.next.next=B [ B-C -> C-B-C]
        B.next = null -> [C-B-null]
        return temp

    temp= C [C-B-null]
    A.next.next=A [A-B ->A-B-A] ( C is also pointing to B at this point)
    A.next= null [B-A-null] (temp= C-B-A-null)
    return temp       
## Code
```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null   || head.next == null ){
            return head;
        }
        ListNode temp =  reverseList(head.next);
        head.next.next = head; //assign the next element's next as the current element. i.e, reverse the element . A-B-null -> A-B-A
        head.next= null;//detach the current element's next B-A-null
        return temp;
    }
}

 

```