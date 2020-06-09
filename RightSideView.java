import java.util.Map;
import java.util.TreeMap;

public class RightSideView {
    static Map<Integer, Integer> mp = new TreeMap<>();

    public static void main(String[] args) {
        RightSideView obj = new RightSideView();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        obj.getRightView(root, 0);
        for (Map.Entry<Integer, Integer> entry : mp.entrySet())
            System.out.print(entry.getValue() + " ");
    }

    private void getRightView(TreeNode root, int level) {
        if (root != null) {
            mp.put(level, root.val);
            getRightView(root.left, level + 1);
            getRightView(root.right, level + 1);
        }
    }
}
