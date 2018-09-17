## Link

https://leetcode.com/problems/trapping-rain-water/
## Input
```
Given a m x n matrix, if an element is 0, set its entire row and column to 0. 

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input: 
[
  [0,1,2,1],
  [3,4,0,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,0,0,0],
  [0,3,0,5]
]
```

## Edge Cases
- null matrix

## Questions/Assumptions

## Code flow
### Thought Process (To be ignored)
- Loop through every value of matrix, if encounter 0, call expandValue passing i and j as input. In expand value, set the current i, and j and 0
    (Similar to expanding for islands problem). But this expansion will cause further rows and columns to be zeroes. 
        - Set first rows and column to be zeroes for the value that is encountered by zeroes. (Do not touch the first column when the first row is set as 0)
            - How to identify if the first row/column should be made zero (
                - if first row already contain 0 ? set whole first row zero
                - if first column already contain 0? set first column to zero )
            (This check should be made before setting the first rows and columns be zero by boolean variable)

### Logic
- for value in matrix

    - if 0
        - if i is 0, set rowflag as 0
        - if j is 0, set columnflag as 0 
        - set ith row as 0, jth column as 0
- for i -> 0 to row length
    if value =0
        - set ith row as 0, for j = 1 to columnSize 
- for j -> 0 to column length
    if j=0 and value = 0
        - set jth column as 0
if rowflag
    set first row as 0
if columnflag
    set first column as 0



## Pseudo code
```
(1: Mark first row and column as 0, for future update) 
for i -> 0 to rowSize
    for j -> 0 to columnSize
        if array[i][j] = 0
            if i = 0
                isFirstRowZero = true  
            if j = 0
                isFirstColumnZero = true
            array[i][0] = 0
            array[0][j] = 0
(2: Set values of the row with zero, which has zero in first row) 
for i ->1 to rowSize
    if array[i][0] = 0
        updateRowAsZero(i-> row)
(3: Set values of the column with zero, which has zero in first column) 
for j ->1 to columnSize
    if array[0][j] = 0
        updateColumnAsZero(j-> column)
(4: if first row had 0, then set whole first row to 0) 
if isFirstRowZero=true
    updateRowAsZero(0-> row)
(5: if first column had 0, then set whole first column to 0) 
if isFirstColumnZero=true
    updateColumnAsZero(0-> column)

updateRowAsZero(row)
    for j = 0  to columnSize
        set array[row][j] = 0

updateColumnAsZero(column)
    for i = 0  to rowSize
        set array[i][column] = 0

```




## Test Input (To be ignored)
Input:
[0,1,2,1],
[3,4,0,2],
[1,3,1,5]

(1: Mark first row and column as 0, for future update)
[0,1,0,1],
[0,4,0,2],
[1,3,1,5]
isFirstRowZero = true
isFirstColumnZero = true

(2: Set values of the row with zero, which has zero in first row) 
[0,1,0,1],
[0,0,0,0],
[1,3,1,5]

(3: Set values of the column with zero, which has zero in first column) 
[0,1,0,1],
[0,0,0,0],
[1,3,0,5]

(4: if first row had 0, then set whole first row to 0) 
[0,0,0,0],
[0,0,0,0],
[1,3,0,5]

(5: if first column had 0, then set whole first column to 0)
[0,0,0,0],
[0,0,0,0],
[0,3,0,5] 

## Similar Problems


## Tags
Arrays
## Code
```java


class Solution {
    public static void setZeroes(int[][] matrix) {
        if(matrix ==  null ){
            return;
        }
        int rowSize = matrix.length;
        int columnSize=  matrix[0].length;
        boolean isFirstRowZero =  false;
        boolean isFirstColumnZero =  false;
        for(int i = 0;i<rowSize;i++){
            for (int j=0;j< columnSize; j++){
                if (matrix[i][j]==0){
                    if(i==0){
                        isFirstRowZero = true;
                    }
                    if(j==0){
                        isFirstColumnZero = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i =1;i< rowSize;i++){
            if(matrix[i][0]==0){
                updateRowAsZero(matrix, i, rowSize, columnSize);
            }
        }
        for (int j =1;j< columnSize; j++){
            if(matrix[0][j]==0){
                updateColumnAsZero(matrix, j, rowSize, columnSize);
            }
        }
        if(isFirstRowZero){
            updateRowAsZero(matrix, 0, rowSize, columnSize);
        }
        if(isFirstColumnZero){
            updateColumnAsZero(matrix, 0, rowSize, columnSize);
        }
    }


    public static void updateRowAsZero(int[][] matrix, int i, int m, int n){
        for(int col=0; col<n; col++){
            matrix[i][col] = 0;
        }
    }
    
    public static void updateColumnAsZero(int[][] matrix, int j, int m, int n){
        for(int row=0; row<m; row++){
            matrix[row][j] = 0;
        }
    }
}

```