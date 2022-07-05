Q: Given a Binary Search Tree (BST) and a range l-h(inclusive), count the number of nodes in the BST that lie in the given range.

The values smaller than root go to the left side
The values greater and equal to the root go to the right side
Example 1:

Input:
      10
     /  \
    5    50
   /    /  \
  1    40  100
l = 5, h = 45
Output: 3
Explanation: 5 10 40 are the node in the
range
Example 2:

Input:
     5
    /  \
   4    6
  /      \
 3        7
l = 2, h = 8
Output: 5
Explanation: All the nodes are in the
given range.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
A: class Solution
{
    //Function to count number of nodes in BST that lie in the given range.
    int low,high,ans;
    int getCount(Node root,int l, int h)
    {
         low=l;
         high=h;
         ans=0;
        solve(root);
        return ans;
    }
    
    void solve(Node root)
    {
        if(root==null)
            return;
        if(root.data>=low && root.data<=high)
            ans++;
        solve(root.left);
        solve(root.right);
    }
}

  
