Q: 2 players A and B take turns alternatively to play a game in which they have N numbers on a paper. 
   In one turn, a player can replace one of the numbers by any of its factor (except for 1 & the number itself).
   The player who is unable to make a move looses the game. Find the winner of the game if A starts the game and both play optimally.
 Example 1:

Input: nums = [5, 7, 3]
Output: B
Explanation: Since all the numbers are prime,
so A will not be able to make the first move. 

Example 2:

Input: nums = [2, 4, 7, 11]
Outptut: A
Explanation: In the first move A will replace 4
by 2, so the numbers will become [2, 2, 7, 11]
now B will not be able to make a move since all 
the remaining numbers can only be divided by 1 
or the number itself. 
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
class Solution
{
    public boolean isPrime(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)
                return false;
        }
            return true;
    }
    
    public int primeFactor(int n){
        int ans=0;
        int num=n;
        for(int i=2;i<=num/2;i++){
            while(n%i==0){
                ans++;
                n=n/i;
            }
        }
        return ans;
    }
    
    public boolean brainGame(int[] nums)
    {
        int ans=0;
        for(int num:nums){
            if(!isPrime(num))ans=ans^(primeFactor(num)-1);
        }
        return ans!=0;
    }
}
