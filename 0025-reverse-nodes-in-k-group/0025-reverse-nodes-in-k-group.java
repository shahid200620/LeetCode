class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode groupStart = curr;
            
            ListNode tail = groupStart;
            int count = 0;
            while (tail != null && count < k) {
                tail = tail.next;
                count++;
            }
            
            if (count < k) {
                break;
            }
            
            ListNode nextGroupStart = tail;
            ListNode reversedHead = null;
            ListNode currentGroupNode = groupStart;
            
            for (int i = 0; i < k; i++) {
                ListNode nextNode = currentGroupNode.next;
                currentGroupNode.next = reversedHead;
                reversedHead = currentGroupNode;
                currentGroupNode = nextNode;
            }
            
            prev.next = reversedHead;
            groupStart.next = nextGroupStart;
            
            prev = groupStart;
            curr = nextGroupStart;
        }
        
        return dummy.next;
    }
}