Q:Given an positive integer N and a list of N integers A[]. Each element in the array denotes the maximum length of jump you can cover. 
  Find out if you can make it to the last index if you start at the first index of the list.

Example 1:

Input:
N = 6
A[] = {1, 2, 0, 3, 0, 0} 
Output:
1
Explanation:
Jump 1 step from first index to
second index. Then jump 2 steps to reach 
4th index, and now jump 2 steps to reach
the end.
Example 2:

Input:
N = 3
A[] =  {1, 0, 2}
Output:
0
Explanation:
You can't reach the end of the array.
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
  
A:class Solution {
    static int canReach(int[] arr, int n) {
       int reach=0;
       for(int i=0;i<=reach;i++){
           reach=Math.max(reach,i+arr[i]);
           if(reach>=n-1){
            return 1;
           }
       }
       return 0;
    }
}  
