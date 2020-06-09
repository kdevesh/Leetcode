import java.util.Stack;

public class ReverseStack {
    public static void reverse(Stack<Integer> st) {
        if (!st.isEmpty()) {
            int data = st.pop();
            reverse(st);
            insertAtBottom(st, data);
        }

    }

    private static void insertAtBottom(Stack<Integer> st, int data) {
        if (st.isEmpty())
            st.push(data);
        else {
            int num = st.pop();
            insertAtBottom(st, data);
            st.push(num);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println("Before: " + st);
        ReverseStack.reverse(st);
        System.out.println("After: " + st);
    }
}
