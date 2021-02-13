import java.util.LinkedList;
import java.util.Queue;

class NodeX {
    public int val;
    public NodeX left;
    public NodeX right;
    public NodeX next;

    public NodeX() {}

    public NodeX(int _val) {
        val = _val;
    }

    public NodeX(int _val, NodeX _left, NodeX _right, NodeX _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class ConnectSiblings {
    public NodeX connect(NodeX root) {
        Queue<NodeX> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            NodeX nextNode = null;
            while(size!=0){
                NodeX temp = q.remove();
                temp.next = nextNode;
                if(temp.right!=null)
                    q.add(temp.right);
                if(temp.left!=null)
                    q.add(temp.left);
                size--;
                if(size!=0)
                    nextNode = temp;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        NodeX root = new NodeX(1);
        root.left = new NodeX(2);
        root.right = new NodeX(3);
        root.left.left = new NodeX(4);
        root.left.right = new NodeX(5);
        root.right.left = new NodeX(6);
        root.right.right = new NodeX(7);
        ConnectSiblings connectSiblings = new ConnectSiblings();
        print(connectSiblings.connect(root));
    }

    private static void print(NodeX connect) {
        if(connect==null)
            return;
        else {
            System.out.print(connect.val+" ");
            print(connect.left);
            print(connect.right);
        }
    }
}
