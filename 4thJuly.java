Q: Minimum X (xor) A 

Given two integers A and B, the task is to find an integer X such that (X XOR A) is minimum possible and the count of set bit in X is equal to the count of set bits in B.

Example 1:

Input: 
A = 3, B = 5
Output: 3
Explanation:
Binary(A) = Binary(3) = 011
Binary(B) = Binary(5) = 101
The XOR will be minimum when x = 3
i.e. (3 XOR 3) = 0 and the number
of set bits in 3 is equal
to the number of set bits in 5.
Example 2:

Input: 
A = 7, B = 12
Output: 6
Explanation:
(7)2= 111
(12)2= 1100
The XOR will be minimum when x = 6 
i.e. (6 XOR 7) = 1 and the number 
of set bits in 6 is equal to the 
number of set bits in 12.
  
A: class Solution 
   {
    public static int getSetBits(int n){
        int countSetBits=0;
        while(n>0){
            n=n&(n-1);
            countSetBits++;
        }
        return countSetBits;
    }
    public static int minVal(int a, int b) {
        int countA=getSetBits(a);
        int countB=getSetBits(b);
        if(countA>countB){
            int diff=countA-countB;
            while(diff!=0){
                a=a&(a-1);
                diff--;
            }
            return a;
        }
        else if(countB>countA){
            int diff=countB-countA;
            while(diff!=0){
                a=a|(a+1);
                diff--;
            }
            return a;
        }
    return a;
    }
}
