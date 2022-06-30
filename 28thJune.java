Q:Given an array A[] of N positive integers and two positive integers K1 and K2. Find the sum of all elements between 
  K1th and K2th smallest elements of the array. It may be assumed that (1 <= k1 < k2 <= n).

Example 1:

Input:
N  = 7
A[] = {20, 8, 22, 4, 12, 10, 14}
K1 = 3, K2 = 6
Output:
26
Explanation:
3rd smallest element is 10
6th smallest element is 20
Sum of all element between
K1 & K2 is 12 + 14 = 26
 

Example 2:

Input
N = 6
A[] = {10, 2, 50, 12, 48, 13}
K1= 2, K2 = 6
Output:
73
  
A:class Solution { 
    public static long sumBetweenTwoKth(long arr[], long N, long K1, long K2)
    {
        long sum=0;
        long first=kthSmallest(arr,K1);
        long second=kthSmallest(arr,K2);
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>first && arr[i]<second)
            {
                sum+=arr[i];
            }
        }
        return sum;
    }
    public static long kthSmallest(long arr[],long k)
    {
        PriorityQueue<Long>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++)
        {
            pq.add(arr[i]);
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        return pq.poll();
    }
 }
