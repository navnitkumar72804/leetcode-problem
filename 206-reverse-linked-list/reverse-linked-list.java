class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode post=null;

        while (curr!= null) {
            post=curr.next;
            curr.next=prev;
            prev=curr;
            curr=post;
        }

        return prev;
    }
}
