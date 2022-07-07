Given a Binary Tree, print the diagonal traversal of the binary tree.
Consider lines of slope -1 passing between nodes. Given a Binary Tree, print all diagonal elements in a binary tree belonging to same line.

Example 1:

Input :
            8
         /     \
        3      10
      /   \      \
     1     6     14
         /   \   /
        4     7 13
Output : 8 10 14 3 6 7 13 1 4
Explanation:
unnamed
Diagonal Traversal of binary tree : 
 8 10 14 3 6 7 13 1 4
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
A:class Tree
  {
     public ArrayList<Integer> diagonal(Node root)
      {
          ArrayList<Integer>res=new ArrayList<>();
          Queue<Node>queue=new LinkedList<>();
          queue.add(root);
          while(!queue.isEmpty()){
               Node temp=queue.peek();
               queue.remove();
               while(temp!=null){
                   if(temp.left!=null){
                       queue.add(temp.left);
                   }
                   res.add(temp.data);
                   temp=temp.right;
               }
           }
           return res;
      }
  }
