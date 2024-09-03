/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
      
        ListNode currNode=head;

            
        int size=0;

        while(currNode!=null){
            currNode=currNode.next;
            size++;
        }

        if(size==n){
            return head.next;
        }

      ListNode newNode=head;
      int index=1;
      int positionIndex=size-n;

       while(index<positionIndex){
        newNode=newNode.next;
        index++;
       } 
       newNode.next=newNode.next.next;
       return head;


    }
}