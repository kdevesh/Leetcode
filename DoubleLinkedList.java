import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

class DLL {
    DLL next;
    DLL prev;
    int data;

    DLL(int data) {
        this.data = data;
    }
}

public class DoubleLinkedList {
    public DLL insert(DLL head, int data) {
        if (head == null)
            head = new DLL(data);
        else {
            DLL temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = new DLL(data);
            temp.next.prev = temp;
        }
        return head;
    }

    public void print(DLL head) {
        DLL temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        DLL head = null;
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        head = doubleLinkedList.insert(head, 1);
        head = doubleLinkedList.insert(head, 2);
        head = doubleLinkedList.insert(head, 3);
        head = doubleLinkedList.insert(head, 4);
        head = doubleLinkedList.insert(head, 5);
        doubleLinkedList.print(head);
    }
    public void generateRandomKey() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 8;
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        long timestamp  = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        buffer.putLong(timestamp);
        SecureRandom random = new SecureRandom(buffer.array());

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);
    }
}
