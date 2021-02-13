class LList {
    int data;
    LList next;

    public LList(int data) {
        this.data = data;
    }
}

public class ReverseLinkedList {
    public static void main(String[] args) {
        LList head = new LList(1);
        head.next = new LList(2);
        head.next.next = new LList(3);
        head.next.next.next = new LList(4);
        head.next.next.next.next = new LList(5);
        head = reverseList(head);
        while (head!=null)
        {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
    private static LList reverseList(LList head)
    {
        LList current = head,prev = null,next = null;
        while(current!=null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}
