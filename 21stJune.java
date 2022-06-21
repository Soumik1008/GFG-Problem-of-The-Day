Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
Note: Here Size is equal to the number of nodes in the subtree.

Example 1:

Input:
        1
      /   \
     4     4
   /   \
  6     8
Output: 1
Explanation: There's no sub-tree with size
greater than 1 which forms a BST. All the
leaf Nodes are the BSTs with size equal
to 1.
Example 2:

Input: 6 6 3 N 2 9 3 N 8 8 2
            6
        /       \
       6         3
        \      /   \
         2    9     3
          \  /  \
          8 8    2 
Output: 2
Explanation: The following sub-tree is a
BST of size 2: 
       2
    /    \ 
   N      8
         
         
         
class BSTNode 
{
    int maxNodeVal;
    int minNodeVal;
    int maxSize;
    
    public BSTNode(int minNodeVal, int maxNodeVal, int maxSize) 
    {
        this.minNodeVal = minNodeVal;
        this.maxNodeVal = maxNodeVal;
        this.maxSize = maxSize;
    }
}

class Solution
{

    public static BSTNode helper(Node root) {
        if (root == null) {
            return new BSTNode(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        
        BSTNode left = helper(root.left);
        BSTNode right = helper(root.right);

        if (left.maxNodeVal < root.data && root.data < right.minNodeVal) {
            return new BSTNode(Math.min(left.minNodeVal, root.data), Math.max(right.maxNodeVal, root.data), left.maxSize + right.maxSize + 1);
        }
        
        return new BSTNode(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
    
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        if (root == null) 
          return 0;
        return helper(root).maxSize;
    }
    
}
