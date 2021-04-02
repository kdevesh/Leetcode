public class LinedListMergeSort {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getMiddle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    public ListNode getMiddle(ListNode head) {
        ListNode slow = head, prev = head;
        while (head != null && head.next != null) {
            prev = slow;
            slow = slow.next;
            head = head.next.next;
        }
        ListNode mid = slow;
        prev.next = null;
        return mid;
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val < list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        } else {
            list2.next = merge(list1, list2.next);
            return list2;
        }

    }
}
