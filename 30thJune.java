Given a value N. In how many ways you can construct a grid of size N x 4 using tiles of size 1 x 4.


Example 1:

Input: N = 1
Output: 1
Explaination: There is only one way.

Example 2:

Input: N = 4
Output: 2
Explaination: The first way can be when all 
the 1 x 4 tiles are arranged horizontally. 
Second way can be when all the 1 x 4 tiles 
are arranged vertically.
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------  
A:class Solution
  {
    static long arrangeTiles(int N){
       long dp[]=new long[N+1];
       for(int i=0;i<=N;i++){
           dp[i]=1;
       }
       for(int i=4;i<=N;i++){
           dp[i]=dp[i-1]+dp[i-4];
       }
       return dp[N];
    }
  }
