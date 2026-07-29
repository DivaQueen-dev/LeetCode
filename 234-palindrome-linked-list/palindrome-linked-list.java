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
    ListNode getmid(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast==null){
            return slow;
        }
        return slow.next;
    }
    ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
       ListNode mid=reverse(getmid(head));
       while(mid!=null){
            if(head.val!=mid.val){
                return false;
            }
            head=head.next;
            mid=mid.next;     
       }
       return true;
    }
}