Q: Reverse a sublist of a linked list 

Given a linked list and positions m and n. Reverse the linked list from position m to n.

Example 1:

Input :
N = 10
Linked List = 1->7->5->3->9->8->10
                      ->2->2->5->NULL
m = 1, n = 8
Output : 2 10 8 9 3 5 7 1 2 5 
Explanation :
The nodes from position 1 to 8 
are reversed, resulting in 
2 10 8 9 3 5 7 1 2 5.

Example 2:

Input:
N = 6
Linked List = 1->2->3->4->5->6->NULL
m = 2, n = 4
Output: 1 4 3 2 5 6
Explanation:
Nodes from position 2 to 4 
are reversed resulting in
1 4 3 2 5 6.
Your task :
 
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
 
Constraints:
1<=N<=10^5


A: class Solution
  {
      public static Node reverseBetween(Node head, int start, int end)
      {
        if(head==null || start==end)
        return head;
        
        Node dummy=new Node(-1);
        dummy.next=head;
        Node nodeBeforeSublist=dummy;
        
        int pos=1;
        while(pos<start){
            nodeBeforeSublist=nodeBeforeSublist.next;
            pos++;
        }
        Node workingPtr=nodeBeforeSublist.next;
        while(start<end){
            Node nodeToBeExtracted=workingPtr.next;
            workingPtr.next=nodeToBeExtracted.next;
            nodeToBeExtracted.next=nodeBeforeSublist.next;
            nodeBeforeSublist.next=nodeToBeExtracted;
            start++;
        }
        return dummy.next;
      }
  }
