/*
https://leetcode.com/problems/roman-to-integer/description/
Input:
Roman Number XX (Input is guaranteed to be within the range from 1 to 3999.)
Output: Integer Number (20)

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

Edge Cases:
 IV (Subtraction instead of addition)
* I can be placed before V (5) and X (10) to make 4 and 9. 
* X can be placed before L (50) and C (100) to make 40 and 90. 
* C can be placed before D (500) and M (1000) to make 400 and 900.
Eg: LVIII
50+5+1+1+1

Code flow:
1. Initialize sum to 0
2. Since the value depends on the previous number. Process the value of previous and keep it separately. 
3. Using for loop, Sum or subtract the previous value as we process the number. (Similar to carry)
4. Process the value of the last number 
5. 
6. 

Questions/Assumptions:
1. What if the value is 0. ? 
2. What if there is no input?
3. What is the maximum value of the input?
  


Pseudo code:
Map(Roman, Integer) romanMap
Map(Roman, Roman) previousValueMap
Sum ->0
Prev -> input[0]  
For input.range(1-> length)
    If previousValueMap[current] not null  and == prev
       Sum += romanMap[current]  - romanMap[prev]
        Prev = 0
    else
        If previous !=0
            sum+=romanMap[prev]
            Prev = current
If previous !=0
    sum+ = romanMap[prev]

Sample Input (To be ignored)
1) Input: IV
Sum = 0
Prev = I
For:
    Current = V
    If (true and true)
        Sum +=5 -1 = 4
        Prev = 0
Sum =4

2. Input: LVIII
Sum =0
prev= L
For:
    sum= 

*/
Program:
class Solution {
    public int romanToInt(String s) {
        final char[] sArray = s.toCharArray();
        Map<Character, Integer> romanToInteger = initializeRomanMap();
        Map<Character, Character> previousMap = initializePreviousMap();
        int sum =0;
        char previous = sArray[0];
        char current ;
        for(int i =1;i<sArray.length;i++){
            current = sArray[i];
            if(previousMap.containsKey(current) && previousMap.get(current) == previous){
                sum += romanToInteger.get(current) - romanToInteger.get(previous);
                previous = '0';
            }
            else{
                if(previous !='0'){
                    sum+= romanToInteger.get(previous);
                }
                previous = current;
            }
        }
        if(previous !='0'){
            sum+= romanToInteger.get(previous);
        }
        return sum;
    }
    
    private Map<Character, Integer> initializeRomanMap(){
        Map<Character, Integer> romanToInteger = new HashMap<>();
        romanToInteger.put('I',1);
        romanToInteger.put('V',5);
        romanToInteger.put('X',10);
        romanToInteger.put('L',50);
        romanToInteger.put('C',100);
        romanToInteger.put('D',500);
        romanToInteger.put('M',1000);
        return romanToInteger;
    }
    
    private Map<Character, Character> initializePreviousMap(){
        Map<Character, Character> previousMap = new HashMap<>();
        previousMap.put('V','I');
        previousMap.put('X','I');
        previousMap.put('L','X');
        previousMap.put('C','X');
        previousMap.put('D','C');
        previousMap.put('M','C');
        return previousMap;
    }
}