## Link

https://leetcode.com/problems/word-ladder/description/
## Input
```
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation. 
```

## Edge Cases


## Questions/Assumptions

## Code flow
### Thought Process
- Take the begin word and put it in reachedList
	- Find its list of successors (Words that can be reached from the word, in one move). 
	- repeat for all successors, till the final word is reached. 



### Logic
-Take begin word , add to reached set
- for each word in reached
	- find successor word
	- add to toReach set
	- if successor equals endWord, return distance value
	- Make toReach as reached, and repeat
	


## Pseudo code
```
reached.add(beginWord)
distance = 0
while reached not contains endWord
	for word in reached
		findSuccessorWord(beginWord, wordDict, toReach)
		distance+1
		
	if toAdd size = 0, return 0
	reached=toAdd


findSuccessorWord(beginWord, wordDict, toReach)
for each character in beginWord
	for each alphabet
		if wordDict.contains(successorWord) 
			toAdd.add successorWord
			wordDict.remove successorWord

```


## Test Input (To be ignored)
```
In start: reached: [hit], wordSet: [lot, log, dot, cog, hot, dog]
In Loop 1:  reached: [hit], wordSet: [lot, log, dot, cog, dog] , toReach: [hot]
In Loop 2:  reached: [hot], wordSet: [log, cog, dog] , toReach: [lot, dot]
In Loop 3:  reached: [lot, dot], wordSet: [cog] , toReach: [log, dog]
In Loop 4:  reached: [log, dog], wordSet: [] , toReach: [cog]
In end: reached: [cog], wordSet: []
```

## Similar Problems


## Tags
HashSet, BreadFirstSearch
## Code
```java


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        int distance = 1;
        while(!reached.contains(endWord)){
            Set<String> toReach = new HashSet<>();
            for(String reachWord:reached){
                findSuccessorWords(reachWord, toReach, wordSet);
            }
            if(toReach.isEmpty()){
                return 0;
            }
            reached = toReach;
            distance++;
        }
        return distance;
    }
    
    
    public void findSuccessorWords( String reachWord, Set<String> toReach, Set<String> wordSet){
        for(int i =0;i<reachWord.length();i++){
            char[] reachWordArray = reachWord.toCharArray();
            for(int k=0;k<26;k++){
                reachWordArray[i] = (char)(k+'a');
                String newWord = new String(reachWordArray);
                if(wordSet.contains(newWord)){
                    toReach.add(newWord);
                    wordSet.remove(newWord);
                }
            }
        }
    }
}

```