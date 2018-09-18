## Link

https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

## Input
```
You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"

no global variables
no static variables

```

## Edge Cases
Empty binary tree

## Questions/Assumptions

## Reason
Preorder Traversal: Elements of root and its children follow a natural order in array
## Code flow
### Logic
- serializeTree(Tree)
	- if node null, return "X"
	- else
		- add node to StringBuffer
		- serializeTree(node.left)
		- serializeTree(node.right)

- deserializeTree (queue)
	- value = queue.pop
	- if value="X" return null
	- else
		- node= Node(value)
		- node.left = deserializeTree(queue)
		- node.right = deserializeTree(queue)

## Pseudo code
```
serializeTree(TreeNode node, String s)
	if(node = null)
		return "X"
	else
		s.add(node.val)
		serializeTree(node.left)
		serializeTree(node.right)

deserializeTree(s)
	queue = List(s.split)
	deserializeTree(queue)

deserializeTree(queue)
	if queue.isEmpty return null
	value= queue.pop
	if(value="X")
		return null
	else
		node = Node(value)
		node.left = deserializeTree(queue)
		node.right = deserializeTree(queue)
		return node
```


## Test Input (To be ignored)
```
Input:
    1
   / \
  2   3
     / \
    4   5

After Serialization:
1,2,X,X,3,4,X,X,5,X

After Deserialization:
			1
	2				3
				4		5
		


```
## Tags
Queue, Tree 
## Code
```java
public class Codec {
    final static String delimiter = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = serialize(root, new StringBuffer());
        return sb.toString();
        
    }
    public StringBuffer serialize(TreeNode root, StringBuffer sb) {
        if(root == null){
            return sb.append("X"+delimiter);
        }
        else{
            sb.append(root.val).append(delimiter);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
        return sb;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(delimiter)));
        return deserialize(queue);
    }
    
    public TreeNode deserialize(Queue<String> queue) {
        if(queue.isEmpty()){
            return null;
        }
        String value = queue.remove();
        if(value.equals("X")){
            return null;
        }
        else{
            int i = Integer.parseInt(value);
            TreeNode node = new TreeNode(i);
            node.left = deserialize(queue);
            node.right = deserialize(queue);
            return node;
        }
    }
}


```