# specialString
You are given an integer K and a string S that contains lowercase English alphabets of length N where N is always a multiple of K. 
You are required to convert the given string to a special string.  
A special string is a string that follows a repeating pattern of K character till the total length of the string is N. For example, if S=abcdef and K=2, then the special string can be ababab or bcbcbc or any other string that follows the mentioned criteria.  

In order to convert the string, you can perform an operation on the string. Considering lowercase English alphabet are set as ciircular, you can rotate the character of the string on either side in one operation. For example, for a you can rotate it to b or z. You can perform this operation any number of time on any character of the string. Performing this operation once costs you 1 unit.  Your task is to convert the given string to a special string in the minimum cost.

Constraints:
1) 1 <=  T <= 10 ; T is the number of samples.
2) 1 <= K <= 100
3) 1 <= N <= 10^6

Sample Input/output:

Input: 
3
3 abcdefghi
3 abcabcabc
3 abcdefabc

Output:
Count: 3
string 0: 3 abcdefghi
Cost : 18
string 1: 3 abcabcabc
Cost : 0
string 2: 3 abcdefabc
Cost : 9
