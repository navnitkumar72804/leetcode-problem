class Solution {
    public ListNode oddEvenList(ListNode head) {
        // Handle edge cases: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }
        
        // Odd pointer starts at head (index 1)
        ListNode odd = head;
        
        // Even pointer starts at head.next (index 2)
        ListNode even = head.next;
        
        // Save the head of even list to connect later
        ListNode evenHead = even;
        
        // Move both pointers by 2 steps each
        while (even != null && even.next != null) {
            // Connect odd node to next odd node (skip one even node)
            odd.next = even.next;
            odd = odd.next;
            
            // Connect even node to next even node (skip one odd node)
            even.next = odd.next;
            even = even.next;
        }
        
        // Connect odd list to even list
        odd.next = evenHead;
        
        return head;
    }
}