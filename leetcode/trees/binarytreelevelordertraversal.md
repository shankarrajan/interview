## Link

https://leetcode.com/problems/binary-tree-level-order-traversal/description/

## Input
```
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]


```

## Edge Cases
Empty binary tree

## Questions/Assumptions

## Code flow
### Logic
- add root to queue
- while queue not empty 
    - set queueSize as queue Length
    - while queueSize is 0
        - pop element from queue , add to list
        - add its children to queue. 
        - queueSize --
    add list to another list

## Pseudo code
```
queue.add(root)
while queue != null
    queueSize = queue.size
    List currentLevelList
    while queueSize>0
        TreeNode node = queue.pop.
        queue.add(node.left)
        queue.add(node.right)
        currentLevelList.add(node.val)
        queueSize--
    totalList.add(currentLevelList)

```


## Test Input (To be ignored)


## Tags
Queue, Tree 
## Code
```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> totalList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null ){
            queue.add(root);
            while (!queue.isEmpty()) {
                int queueSize = queue.size();
                List<Integer> currentLevelList = new ArrayList<>();
                while (queueSize > 0) {
                    TreeNode node = ((LinkedList<TreeNode>) queue).pop();
                    currentLevelList.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    queueSize--;
                }
                totalList.add(currentLevelList);
            }
        }
        return totalList; 
    }
}


```