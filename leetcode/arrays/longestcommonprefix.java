/*
Question: https://leetcode.com/problems/longest-common-prefix/description/
Input: ["flower","flow","flight"]
Output: "fl"

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Assumptions/Questions:

Edge cases:
1. Empty Input
Code flow:
	for each string, 
		get the first character. Check if it is equal to the previous character. Repeat for all strings. 
		Store the previous character in final output. Repeat till any of the characters become null for any string. 

Psuedocode:
	while true
		for each string in string array
			if previous value is null, set previous as string of index i. 
			else
				check if previous equals string of index i. if index i is null or previous does not match, break
		add previous to output, if previousCount is size of string array and previous as null

Test:
Input: ["flower","flow","flight"]
			for-> (flower: f, i =0) previous = null, -> previous=f
				(flow:f, i=0) previous matches, increment previousCount
				(flight: f, i=0, previous matches, increment previousCount)
			output+=input[0][i] (output=f), previous = null
			
			for-> (flower: f, i =1) previous = null,-> previous=f
				(flow:f, i=1) previous matches, increment previousCount
				(flight: f, i=1, previous matches, increment previousCount)
			output+=input[0][i] (output=f), previous = null	
*/
class Solution {
    public static String longestCommonPrefix(String[] strs) {
        StringBuffer output = new StringBuffer();
        int matchCount= 0;
        Character prev = null;
        int index = 0;
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        while(true){
            for(String s :strs){
                if(index>=s.length()){
                    break;
                }
                char c = s.charAt(index);
                if(prev== null){
                    prev = c;
                    matchCount++;
                }
                else if(prev == c){
                    matchCount++;
                }
                else{
                    break;
                }
            }
            if(matchCount == strs.length){
                output.append(strs[0].charAt(index));
                prev= null;
                index++;
                matchCount=0;
            }
            else{
                break;
            }
        }
        return output.toString();
    }
}



			