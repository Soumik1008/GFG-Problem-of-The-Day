// Smallest Factorial Number

Given a number n. The task is to find the smallest number whose factorial contains at least n trailing zeroes.

Example 1:

Input:
n = 1
Output: 5
Explanation : 5! = 120 which has at
least 1 trailing 0.


Example 2:

Input:
n = 6
Output: 25
Explanation : 25! has at least
6 trailing 0.

User Task:
Complete the function findNum() which takes an integer N as input parameters, and returns the answer.

Expected Time Complexity: O(log2 N * log5 N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= n <= 104

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Code:

class Solution
{
    int findNum(int n)
    {
        int low=0;
        int high=5*n;
        int ans=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int zeroes=findZeroes(mid);
            if(zeroes>=n)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
    
    int findZeroes(int x)
    {
        int zeroes=0;
        int denominator=5;
        while(denominator<=x)
        {
            zeroes+=(x/denominator);
            denominator=denominator*5;
        }
    return zeroes;
    }
}
