## Link

https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
## Input
Given a string, find the length of the longest substring without repeating characters.

*Input*: "abcabcbb"
*Output*: 3 
*Explanation*: The answer is "abc", with the length of 3. 

*Input*: "bbbbb"
*Output*: 1
*Explanation*: The answer is "b", with the length of 1.

## Edge Cases
- Size of input string is zero
- 

## Questions/Assumptions

## Code flow
- Keep the character in hashmap and index as its value. 
- For each character in string, 
	If in hashmap, 
		Set endPosition value as startPosition+1
- update hashmap of character and value as startPosition
- update max as max of j-i+1, max

## Pseudo code
Map characterWithIndex
startPosition = 0
max = 0
for endPosition-> 0 to s.length
	if current char in characterWithIndex
		endPosition = max of j, characterWithIndex+1
	put char,endPosition in characterWithIndex
	max = max of max, endPosition- startPosition+1


## Test Input (To be ignored)



## Code
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map characterWithIndex = new HashMap<Character, Integer>();
        int startPosition = 0;
        int max =0;
        for (int endPosition=0;endPosition<s.length();endPosition++){
        	if(characterWithIndex.containsKey(s.charAt(endPosition))){
        		startPosition = Math.max(startPosition, characterWithIndex.get(s.charAt(endPosition)));
        	}
        	characterWithIndex.put(s.charAt(endPosition), endPosition);
        	max= Math.max(max, endPosition - startPosition +1);
        }
    }
}
```