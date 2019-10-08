import java.util.*;
public class VerticalSumBT {
    public static void printVertical(Node root) {
        // add your code here
        Map<Integer, Integer> mp = new TreeMap<>();
        verticalSum(root, mp, 0);
        mp.forEach((k, v) -> System.out.print(v + " "));

    }

    public static void verticalSum(Node root, Map<Integer, Integer> mp, int level) {
        if (root == null)
            return;
        else {
            if (mp.containsKey(level))
                mp.put(level, mp.get(level) + root.data);
            else
                mp.put(level, root.data);
            verticalSum(root.left, mp, level - 1);
            verticalSum(root.right, mp, level + 1);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(20);
        printVertical(root);
    }
}