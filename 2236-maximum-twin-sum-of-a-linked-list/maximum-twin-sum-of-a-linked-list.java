
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
    public int pairSum(ListNode head) {
         ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=reverseList(slow.next);
        slow.next=temp;

        ListNode p1=head;
        ListNode p2=slow.next;
        int maxSum=Integer.MIN_VALUE;
        while(p2!=null){
           int sum=p1.val+p2.val;
            p1=p1.next;
            p2=p2.next;
            if(sum>maxSum){
                maxSum=sum;
            } 
        }
        return maxSum;
    }
}