Q:Given an equation of the form f(n) = f(n-1) + f(n-2) where f(0) = 1, F(1) = 1 , 
the task is to find the nth term of this sequence.
Example 1:

Input: n = 3
Output: 3
Explanation: f(3) = f(2) + f(1) = 3

Example 2:

Input: n = 2
Output: 2
Explanation: f(2) = f(1) + f(0) = 2
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
A:class Solution
  {
    int mod=1000000007;
    public int FindNthTerm(int n)
    {
        long arr[][]=new long[][]{{1,1},{1,0}};
        long ans[][]=fnc(arr,n);
        return (int)ans[0][0]%mod;
    }
    
    public long[][]multiply(long[][]mat1,long[][]mat2)
    {
        long[][]ans=new long[2][2];
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<2;j++)
            {
                for(int k=0;k<2;k++)
                {
                  ans[i][j]+=(mat1[i][k]*mat2[k][j])%mod;
                }
            }
        }
        return ans;
    }
    
    public long[][] fnc(long[][]arr, int n)
    {
        if(n==1)
            return arr;
        long temp[][]=fnc(arr,n/2);
        if(n%2==0)
            return multiply(temp,temp);
        return multiply(temp,multiply(temp,arr));
    }
}
