## Link

https://leetcode.com/problems/longest-palindromic-substring/
## Input
```
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
```

## Edge Cases
- null string

## Questions/Assumptions

## Code flow
### Thought Process (To be ignored)
- For each character , 
1. Expand it with that as center.  (addresses odd palindrome . eg. aba)
2. Expand with the empty value between two characters as center (even palindrome. eg. abba)



### Logic



## Pseudo code
```
String maxPalindrome ="";
for i= 0 to string length
pal1 = expand(i, i+1, stringArray)
pal2 = expand(i, i, stringArray)
if(pal1.length>maxPalindrome.length)



expand(startPosn, endPosn, array)
    while(startPosn>=0 && endPosn <array.length && array[startPosn] = array[endPosn])
        startPosn =-1;
        endPosn =+1;
    return(array.substring(startPosn+1, endPosn))
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