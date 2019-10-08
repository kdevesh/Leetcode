public class BTisBST {
    public boolean isValidBST(TreeNode root) {
        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean validate(TreeNode root,long min,long max){
        if(root==null)
            return true;
        else{
            if(root.val<=min || root.val>=max)
                return false;
            return validate(root.left,min,root.val) && validate(root.right,root.val,max);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(11);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(12);
        System.out.println(new BTisBST().isValidBST(root));
    }
}
