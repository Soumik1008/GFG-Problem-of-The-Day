Q: Given N, the number of plots on either sides of the road. Find the total ways to construct buildings in the plots such that there is a space between any 2 buildings. All plots on one side of the road are continuous.
Lets suppose * represents a plot, then for N=3, the plots can be represented as * * * | | * * *                               

Where | | represents the road.                                                                                                                                                                  
Note: As the answer can be very large, print it mod 1000000007

 

Example 1:

Input: N = 3
Output: 25
Explanation: 3 plots, which means possible
ways for one side are BSS, BSB, SSS, SBS,
SSB where B represents a building and S
represents an empty space Total possible 
ways are 25, because a way to place on one
side can correspond to any of 5 ways on other
side.
  
Example 2:

Input: N = 10
Output: 20736
Explanation: There are 20736 ways for N = 10.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

  Roughly, for n=1;
  -Road-
  S Road B 
  B Road S 
  S Road S
  B Road B
  So, f(1)=2
    
    for n=2;
  S S Road        S S Road
  S B Road   X    S B Road
  B S Road        B S Road
  So,f(2)=3
    
   for n=3,
S S S     S S S
S B S     S B S
B S S  X  B S S
B S B     B S B
B S S     B S S
So, f(3)=f(1)+f(2)=2+3=5

  A: class Solution
  {
    public int TotalWays(int N)
    {
        int mod=1000000007;
        long dp[]=new long[N+1];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<=N;i++)
        {
            dp[i]=(dp[i-1]+dp[i-2])%mod;
        }
        return (int)((dp[N]*dp[N])%mod);
    }
 }
