## Link

https://leetcode.com/problems/letter-combinations-of-a-phone-number/
## Input
```
Example:
Set:[0:"", 1:"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]


Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
```

## Edge Cases
- null matrix

## Questions/Assumptions

## Code flow
### Thought Process (To be ignored)
add empty value to result
for i in input 23 (i)
    loop through 23
    get value of 2 [abc]
    for each j in abc 
        for each val in result
            temp =  val + j 
    result = temp

## Pseudo code
```
result.add("")
for i in input
    charMap = numberToCharacter.get(i)
    for ch in charMap
        for val in result
            temp.add(val+ch)
    result=temp

```




## Test Input (To be ignored)
input: 23
result=""
for i in 23
(loop:1)[i=2]
    char[] charmap = key.get(i)-> abc
    for ch in charmap
        (loop:1.1)[ch=a]
        for res in result
            (loop:1.1.1 )[res=""]
            temp.add(res + ch) temp=[a]
        (loop:1.2)[ch=b]
            temp=[a,b]
        (loop:1.3)[ch=c]
            temp=[a,b,c]
    result=[a, b, c]

(loop:2) [i=3]
    char[] charmap = key.get(i)-> def
    for ch in charmap
        (loop:2.1)[ch=d]
        for res in result
            (loop:2.1.1 )[res=a]
            temp.add(res + ch) temp=[ad]
            (loop:2.1.2 )[res=b]
            temp.add(res + ch) temp=[ad, bd]
            (loop:2.1.3 )[res=c]
            temp.add(res + ch) temp=[ad, bd, cd]
        (loop:2.2)[ch=e]
            for res in result
            (loop:2.2.1 )[res=a]
            temp.add(res + ch) temp=[ad, bd, cd, ae]
            (loop:2.2.2 )[res=b]
            temp.add(res + ch) temp=[ad, bd, cd, ae, be]
            (loop:2.2.3 )[res=c]
            temp.add(res + ch) temp=[ad, bd, cd, ae, be, ce]

        (loop:2.3)[ch=f]
            for res in result
            (loop:2.3.1 )[res=a]
            temp.add(res + ch) temp=[ad, bd, cd, ae, be, ce, af]
            (loop:2.3.2 )[res=b]
            temp.add(res + ch) temp=[ad, bd, cd, ae, be, ce, af, bf]
            (loop:2.3.3 )[res=c]
            temp.add(res + ch) temp=[ad, bd, cd, ae, be, ce, af, bf, cf]
    
## Similar Problems


## Tags
backtracking
## Code
```java


class Solution {
    public List<String> letterCombinations(String digits) {
        String[] keyMapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        List<String> result = new ArrayList<>();
        if(digits.length()==0){
            return result;
        }
        result.add("");
        for( char i:digits.toCharArray()){
            String charMapping = keyMapping[i-'0'];
            List<String> tempList = new ArrayList<>();
            for(char j:charMapping.toCharArray()){
                for(String val: result){
                    tempList.add(val+j);
                }
            }
            result = tempList;
        }
        return result;
    }
}

```