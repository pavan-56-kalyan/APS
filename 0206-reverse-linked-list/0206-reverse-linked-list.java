class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next; // store next node
            curr.next = prev;              // reverse pointer
            prev = curr;                   // move prev forward
            curr = nextTemp;               // move curr forward
        }
        return prev; // new head
    }
}