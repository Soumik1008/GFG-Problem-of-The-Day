Q:
Given an array arr[] of n integers. Count the total number of sub-array having total distinct elements same as that
of total distinct elements of the original array.

Example 1:

Input:
N=5
arr[] = {2, 1, 3, 2, 3} 
Output: 5
Explanation:
Total distinct elements in array is 3
Total sub-arrays that satisfy the condition
are:
Subarray from index 0 to 2
Subarray from index 0 to 3
Subarray from index 0 to 4
Subarray from index 1 to 3
Subarray from index 1 to 4

Example 2:

Input:
N=5
arr[] = {2, 4, 4, 2, 4} 
Output: 9

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. 
You just need to complete the function countDistinctSubarray() that takes array arr and integer n  as parameters and returns the desired result.

 
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
  
A:

class Solution
{ 
    // Method to calculate distinct sub-array 
    static int countDistinctSubarray(int arr[], int n) 
    { 
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int start=0;
        int end=0;
        int count=0;
        int k=set.size();
        HashMap<Integer,Integer>map=new HashMap<>();
        while(end<n)
        {
            if(map.containsKey(arr[end])){
               map.put(arr[end],map.get(arr[end])+1); 
            }
            else{
               map.put(arr[end],1);
            }
            if(map.size()==k)
            {
                count+=n-end;
                while(map.size()==k)
                {
                    int get=map.get(arr[start]);
                    get=get-1;
                    if(get==0)
                    {
                        map.remove(arr[start]);
                    }
                    else
                    {
                        map.put(arr[start],get);
                        count+=n-end;
                    }
                    start++;
                }
            }
            end++;
        }
        return count;
    }
}
