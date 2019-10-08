public class MaxPathSum {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return res;
    }

    public int helper(TreeNode root) {
        if(root == null) return 0;

        int left = Math.max(0,helper(root.left));
        int right = Math.max(0,helper(root.right));

        res = Math.max(res, left + right + root.val);

        return Math.max(left,right) + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new MaxPathSum().maxPathSum(root));
    }

}