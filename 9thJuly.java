Polynomial Addition 
Q: Given two polynomial numbers represented by a linked list. The task is to complete the function addPolynomial() that adds these lists meaning adds the coefficients who have the same variable powers.
Note:  Given polynomials are sorted in decreasing order of power.

Example 1:

Input:
LinkedList1:  (1,x2) 
LinkedList2:  (1,x3)
Output:
1x^3 + 1x^2
Explanation: Since, x2 and x3 both have
different powers as 2 and 3. So, their
coefficient can't be added up.
Example 2:

Input:
LinkedList1:  (1,x3) -> (2,x2)
LinkedList2:  (3,x3) -> (4,x2)
Output:
4x^3 + 6x^2
Explanation: Since, x3 has two different
coefficients as 3 and 1. Adding them up
will lead to 4x3. Also, x2 has two
coefficients as 4 and 2. So, adding them
up will give 6x2.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
class Solution
{
    public static Node addPolynomial(Node p1,Node p2)
    {
        Node ans=new Node(-1,-1);
        Node curr=ans;
        Node temp1=p1;
        Node temp2=p2;
        while(temp1!=null && temp2!=null){
            if(temp1.pow==temp2.pow){
                curr.next=new Node(temp1.coeff+temp2.coeff,temp1.pow);
                curr=curr.next;
                temp1=temp1.next;
                temp2=temp2.next;
            }
            else if(temp2.pow<temp1.pow){
                curr.next=new Node(temp1.coeff,temp1.pow);
                curr=curr.next;
                temp1=temp1.next;
            }
            else{
                curr.next=new Node(temp2.coeff,temp2.pow);
                curr=curr.next;
                temp2=temp2.next;
            }
            if(temp1!=null){
                curr.next=temp1;
            }
            if(temp2!=null){
                curr.next=temp2;
            }
        }
        return ans.next;
    }
}
