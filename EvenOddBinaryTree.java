import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class EvenOddBinaryTree {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean isOddEven = true;
        int level = 0;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Integer evenPrev = null;
            Integer oddPrev = null;
            while (size != 0) {
                TreeNode node = q.remove();
                if (level % 2 == 0) {
                    if (node.val % 2 == 0) {
                        isOddEven = false;
                        break;
                    } else {
                        if (evenPrev == null)
                            evenPrev = node.val;
                        else {
                            if (node.val <= evenPrev) {
                                isOddEven = false;
                                break;
                            }
                            else
                                evenPrev = node.val;
                        }
                    }
                } else {
                    if (node.val % 2 != 0) {
                        isOddEven = false;
                        break;
                    } else {
                        if (oddPrev == null)
                            oddPrev = node.val;
                        else {
                            if (node.val >= oddPrev) {
                                isOddEven = false;
                                break;
                            }
                            else
                                oddPrev = node.val;
                        }
                    }
                }
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                size--;
            }
            if (!isOddEven)
                return isOddEven;
            level++;
        }
        return isOddEven;
    }
}