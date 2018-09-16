## Link

https://leetcode.com/problems/trapping-rain-water/
## Input
```
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
https://github.com/shankarrajan/interview/blob/master/leetcode/resources/arrays_rainwatertrap.png


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
```

## Edge Cases


## Questions/Assumptions

## Code flow
### Logic
- Calculate the left Max array as  maximum height of bar from the left end upto an index i .
- Calculate the right Max array as  maximum height of bar from the right end upto an index i .
- The intersection of both is the amount of water that can be stored. Intersection is calculated as
Min(right[i],left[i])-height[i]


## Pseudo code
```
for i=1 to n    
    left_max[i]=max(left[max[i-1]], current[i])
for i=n-1 to 0
    right_max[i]=max(right[max[i+1]], current[i])
for i=0 to n
    sum+=min(left_max[i], right_max[i])-current[i]    
```


## Test Input (To be ignored)

current =               [0,1,0,2,1,0,1,3,2,1,2,1]
left_max =              [0,1,1,2,2,2,2,3,3,3,3,3]
right_max=              [3,3,3,3,3,3,3,3,2,2,2,1]
min(right_max,left_max)=[0,1,1,2,2,2,2,3,2,2,2,1]
min - current=          [0,0,1,0,1,2,1,0,0,1,0,0]
sum= 6



## Similar Problems


## Tags
Arrays, DynamicProgramming
## Code
```java


class Solution {
    public int trap(int[] height) {
        int size = height.length;
        if(size==0){
            return 0;
        }
        int[] rightMax = new int[size];
        int[] leftMax = new int[size];
/*To consider the value of amount of storage that can be done on the corners */
        leftMax[0] = height[0];
        rightMax[size-1] = height[size-1];
        
        for(int i=1;i<size;i++){
            leftMax[i]= Math.max(leftMax[i-1], height[i]);
        }
        for(int i=size-2;i>=0;i--){
            rightMax[i]= Math.max(rightMax[i+1], height[i]);
        }
        int sum = 0;
        for(int i=0;i<size;i++){
            sum+= Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
        
    }
}

```