
class LLNode {
    int val;
    LLNode next;
    LLNode(int x) { val = x; }
}
public class LinkedListPalin {
    private boolean res=true;
    private LLNode start;
    public boolean isPalindrome(LLNode head) {
        start=head;
        return isPalinHelp(head);
    }
    private boolean isPalinHelp(LLNode head){
        if(head==null)
            return res;
        else{
            res = res&&isPalinHelp(head.next);
            if(head.val!=start.val)
                return false;
            start = start.next;
        }
        return res;
    }

    public static void main(String[] args) {
        LinkedListPalin obj = new LinkedListPalin();
        LLNode head=new LLNode(1);
        head.next = new LLNode(2);
        head.next.next = new LLNode(2);
        head.next.next.next = new LLNode(1);
        System.out.println(obj.isPalindrome(head));
    }
}