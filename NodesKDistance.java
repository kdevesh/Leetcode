/**
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 * <p>
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * <p>
 * Output: [7,4,1]
 */

import java.util.*;

public class NodesKDistance {
    private Map<Integer, TreeNode> map = new HashMap<>();
    private Map<Integer, Boolean> visited = new HashMap<>();

    private List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        fillParent(root, null);
        queue.add(target);
        visited.put(target.val, true);
        int count = 0;
        while (count != K) {
            int size = queue.size();
            while (size != 0) {
                TreeNode node = queue.remove();
                if (node.left != null && !visited.get(node.left.val)) {
                    queue.add(node.left);
                    visited.put(node.left.val, true);
                }
                if (node.right != null && !visited.get(node.right.val)) {
                    queue.add(node.right);
                    visited.put(node.right.val, true);
                }
                if (map.get(node.val) != null) {
                    if (!visited.get(map.get(node.val).val)) {
                        queue.add(map.get(node.val));
                        visited.put(map.get(node.val).val, true);
                    }
                }
                size--;
            }
            count++;
        }
        while (!queue.isEmpty()) {
            res.add(queue.remove().val);
        }
        return res;
    }

    private void fillParent(TreeNode root, TreeNode parent) {
        if (root == null)
            return;
        else {
            map.put(root.val, parent);
            visited.put(root.val, false);
            fillParent(root.left, root);
            fillParent(root.right, root);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        System.out.println(new NodesKDistance().distanceK(root, root.left, 2));
    }
}