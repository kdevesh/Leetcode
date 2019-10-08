class Tree{
    String val;
    Tree left,right;
    Tree(String val){
        this.val = val;
        left = right = null;
    }
}
public class ExpressionTree{
    public int evalTree(Tree root)
    {
        if(root==null)
            return 0;
        else{
            int left = evalTree(root.left);
            int right = evalTree(root.right);
            int sum = 0;
            if(root.val.equals("*"))
                sum = left * right;
            else if(root.val.equals("+"))
                sum = left + right;
            else if(root.val.equals("-"))
                sum = left - right;
            else if(root.val.equals("/"))
                sum = left / right;
            else
                sum = Integer.parseInt(root.val);

            return sum;
        }
    }

    public static void main(String[] args) {
        Tree root = new Tree("+");
        root.left = new Tree("*");
        root.right = new Tree("-");
        root.left.left = new Tree("5");
        root.left.right = new Tree("4");
        root.right.left = new Tree("100");
        root.right.right = new Tree("20");
        System.out.println(new ExpressionTree().evalTree(root));

    }
}