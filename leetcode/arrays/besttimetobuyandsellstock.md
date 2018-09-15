## Link

https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
## Input
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.


## Edge Cases
Empty stock range

## Questions/Assumptions

## Code flow
### Logic
- for each element two things are to be identified. 
    is it the minimum element?
    is it the maximum element -> maxProfit is high


## Pseudo code
set minSoFar = element[0]
for i=1 to element.length
    if element[i]> minSoFar 
        max= max of max, element[i]-minSoFar
    else
        minSoFar = element[i]
return max



## Test Input (To be ignored)


## Tags
Arrays, LocalMinima
## Code
```java


 class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<1){
            return 0;
        }
        int minSoFar = prices[0];
        int maxProfit = 0;
        for(int i =1;i<prices.length;i++){
            if(prices[i]> minSoFar){
                maxProfit = Math.max(maxProfit, prices[i]- minSoFar);
            }
            else{
                minSoFar = prices[i] ;
            }
        }
        return maxProfit;
    }
}
```