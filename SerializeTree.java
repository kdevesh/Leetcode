import java.sql.SQLOutput;
import java.util.*;
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val){
        this.val = val;
    }
}
public class SerializeTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        class Serialize{
            public void serializeBST(TreeNode root){
                if(root==null)
                    str.append("#,");
                else
                {
                    str.append(root.val+",");
                    serializeBST(root.left);
                    serializeBST(root.right);
                }
            }
        }
        new Serialize().serializeBST(root);
        str.deleteCharAt(str.length()-1);
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringTokenizer st = new StringTokenizer(data,",");
        class Deserialize{
            public TreeNode deserializeBST(){
                if(st.hasMoreTokens()){
                    String token = st.nextToken();
                    if(token.equals("#"))
                        return null;
                    else{
                        TreeNode node = new TreeNode(Integer.parseInt(token));
                        node.left = deserializeBST();
                        node.right = deserializeBST();
                        return node;
                    }
                }
                return null;
            }
        }
        return new Deserialize().deserializeBST();
    }

    public static void main(String[] args) {
        SerializeTree obj = new SerializeTree();
        System.out.println(obj.serialize(obj.deserialize("2,1,#,#,3,#,#")));
    }
}