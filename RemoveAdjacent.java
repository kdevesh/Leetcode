import java.util.Stack;
class CustomPair{
    Character ch;
    int count;
    CustomPair(Character ch, int count){
        this.ch = ch;
        this.count = count;
    }
}
public class RemoveAdjacent {
    public static String removeDuplicates(String s, int k) {
        Stack<CustomPair> st = new Stack<>();
        String res = "";
        st.push(new CustomPair(s.charAt(0),1));
        for (int i = 1; i < s.length(); i++) {
            if (!st.isEmpty() && st.peek().ch == s.charAt(i)) {
                CustomPair peek = st.peek();
                st.push(new CustomPair(s.charAt(i),peek.count+1));
                if(peek.count+1==k){
                    for (int j = 0; j < k; j++)
                        st.pop();
                }
            }
            else
                st.push(new CustomPair(s.charAt(i),1));
        }
        while (!st.isEmpty()) {
            res = st.pop().ch + res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("deeedbbcccbdaa",3));
    }
}