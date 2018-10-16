## Link
https://leetcode.com/problems/group-anagrams/description/
## Input
```
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.

```

## Edge Cases
- empty list

## Questions/Assumptions

## Code flow
### Thought Process (To be ignored)
#### Approach 1:
HashMap of key (word sorted in ascending order), and list as value
sort every word and insert into the map
convert values of map to list of list. 

#### Approach 2:
Using prime numbers for each value. 
## Pseudo code
```

Map map
for each word: words
	sortedWord = sort(word)
	listOfWords = map.containsKey(sortedWord)?map.get(sortedWord): new list()
	listOfWords.add(word)
return map.values

```
## Test Input (To be ignored)


```
input: []
expected output: []
actual output:[]

input:[cat,atc]
expected output: [[atc,cat]]
actual output:[[atc,cat]]


```
    
## Similar Problems


## Tags
string
## Code
```java


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> valuesMap = new HashMap<>();
        for(String word: strs){
            String sortedWord = word.chars().sorted().collect(StringBuffer::new, StringBuffer::appendCodePoint, StringBuffer::append).toString();
            List<String> anagrams = valuesMap.containsKey(sortedWord)?valuesMap.get(sortedWord):new ArrayList<>();
            anagrams.add(word);
            valuesMap.put(sortedWord, anagrams);
        }
        return new ArrayList<>(valuesMap.values());
    }
}

```