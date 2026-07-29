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
        ListNode temp=head;
        int sz=0;
        while(temp!=null){
            sz++;
            temp=temp.next;
        }
        if(sz==n){
            head=head.next;
            return head;
        }
        ListNode prev=head;
        int i=1;
        while(i<sz-n){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return head;
    }
}