public class SwapAdjacent {
    public ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        if(temp==null)
            return head;
        else if(temp.next==null)
            return head;
        else{
            head = head.next;
            while(temp!=null)
            {
                ListNode tempNext = temp.next;
                ListNode next = tempNext.next;
                temp.next = tempNext.next!=null?tempNext.next.next:tempNext.next;
                tempNext.next = temp;
                if(next!=null && next.next==null){
                    temp.next = next;
                    temp = next.next;
                }
                else
                    temp  = next;
            }
            return head;
        }
    }
}