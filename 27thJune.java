Q:
Given a number N, complete the following tasks,
Task 1. Generate a new number from N by changing the zeroes in the binary representation of N to 1.
Task  2. Find the difference between N and the newly generated number.

Example 1:

Input: N = 8 
Output: 7 15
Explanation:
There are 3 zeroes in binary representation
of 8. Changing them to 1 will give 15.
Difference between these two is 7.

Example 2:

Input: N = 6 
Output: 1 7
Explanation:
There is 1 zero in binary representation
of 6. Changing it to 1 will give 7.
Difference between these two is 1.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function changeBits() which 
takes an integer N as input parameter and returns a list of two integers containing the difference and the generated number respectively.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------

A:class Solution {
    static int[] changeBits(int N) {
       int n=N;
       int k=0;
       while(N!=0){
           N>>=1;  
           k<<=1;  
           k|=1;   
       }
       int[] arr=new int[2];
       arr[0]=Math.abs(n-k); arr[1]=k;
       return arr;
    }
}
