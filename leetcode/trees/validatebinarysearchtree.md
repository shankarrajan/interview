## Link
https://leetcode.com/problems/validate-binary-search-tree/

## Description

```
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
```



## Edge Cases

* root = null

## Questions/Assumptions



## Thought Process

1. we need to recursively call validatebst for subtrees and if both left and right return properly. then we can return this to be a valid bst. 
2. we need to pass in the value of root to decide the max value (in case for left sub tree), or min value (in case of right sub tree)
3. 

## PseudoCode

```
isValidBST(root, minValue, maxValue)
	//Base Condition. If root is null, then it is ValidBST
	if root is null
		return true
	else
		//Condition for Valid BST
		if(root.data<minValue || root.data> maxValue)
			return false
		else
			// repeat for both left and right trees
    	return isValidBST(root.left,minValue, root.data) && isValidBST(root.right, root.data, maxValue)
```

## Test Input

[2,1,3]

[5,1,4,null,null,3,6]

## Code

```python
    def isValidBST(self, root: TreeNode, minValue= float('-inf'), maxValue= float('inf')) -> bool:
        if not root:
            return True
        else:
            if root.val<=minValue or root.val>=maxValue:
                return False
            else:
                return self.isValidBST(root.left, minValue, root.val) and self.isValidBST(root.right, root.val, maxValue)
```

## Tags

python, tree













