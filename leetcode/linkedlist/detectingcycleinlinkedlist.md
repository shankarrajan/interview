## Link

https://leetcode.com/problems/linked-list-cycle/description/
## Input
```
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

```

## Edge Cases
- null linked list
- single linked list value with pointer to itself

## Questions/Assumptions

## Code flow
### Thought Process (To be ignored)
#### Approach 1:
two pointers (fast and slow: Floyd technique)
fast will go hop two values
slow will go one value
loop till slow = fast

#### Approach 2:
Use hashset to check if value is already encountered

## Pseudo code
```

if p=null return false
slow= p , fast = p.next
while slow != fast
    if (fast = null or fast.next = null)
        return false
    slow = slow.next
    fast = fast.next.next
return true

```
## Test Input (To be ignored)


```
input: 2-> null
expected o/p: false
actual o/p:
1. p not null
2. slow = 2, fast = null
3. 2 != null
    if(null = null) return false

input 2->2 (Self pointer)
expected o/p: true
actual o/p:
1. p not null
2. slow = 2, fast = 2
    2= 2 -> return true

input    2->3->4->5->4 (Loop at 4)
expected o/p: true
actual o/p:
1. p not null
2. slow = 2, fast = 3
3. i) slow != fast (2 != 3)
        fast not null and fast.next not null
        slow = 3
        fast = 5
    ii) slow != fast (3 != 5)
        fast not null and fast.next not null
        slow = 4
        fast = 5
    iii) slow != fast (4 != 5)
        fast not null and fast.next not null
        slow = 5
        fast = 5
    iv) slow = fast -> return true    

```
    
## Similar Problems


## Tags
linkedlist
## Code
```java


class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow= head, fast = head.next;
        while(slow != fast){
            if(fast == null  || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

```