/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class UnivalTree {
    public boolean isUnivalTree(TreeNode root) {
        class Anonymous{
            public boolean univalTree(TreeNode root,int value){
                if(root == null)
                    return true;
                else{
                    if(root.val!=value)
                        return false;
                    return univalTree(root.left,value)&&univalTree(root.right,value);
                }
            }
        }
        return new Anonymous().univalTree(root,root.val);
    }
}