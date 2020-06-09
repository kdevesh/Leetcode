public class LLSum {
    public static void main(String[] args) {
        ListNode l1 = null;
        ListNode l2 = null;
        Solution2 obj = new Solution2();
        l1 = obj.insertNode(l1,1);
        l1 = obj.insertNode(l1,2);
        l1 = obj.insertNode(l1,3);
        l2 = obj.insertNode(l2,9);
        l2 = obj.insertNode(l2,0);
        l2 = obj.insertNode(l2,9);
        ListNode temp = obj.addTwoNumbers(l1,l2);
        while(temp!=null){
            System.out.print(temp.val);
            temp = temp.next;
        }
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null;
        int carry = 0,rem = 0;
        while(l1!=null && l2!=null)
        {
            rem = (l1.val+l2.val+carry)%10;
            carry = (l1.val+l2.val+carry)/10;
            head = insertNode(head,rem);
            l1 = l1.next;
            l2 = l2.next;

        }
        ListNode temp = l1==null?l2:l1;
        while(temp!=null){
            rem = (temp.val+carry)%10;
            carry = (temp.val+carry)/10;
            head = insertNode(head,rem);
            temp = temp.next;
        }
        if(carry!=0)
            head = insertNode(head,carry);
        return head;
    }
    public ListNode insertNode(ListNode head,int data)
    {
        ListNode temp = head;
        ListNode node = new ListNode(data);
        if(head==null)
        {
            node.next=null;
            head = node;
        }
        else{
            while(temp.next!=null)
                temp=temp.next;
            node.next=null;
            temp.next = node;
        }
        return head;
    }
}