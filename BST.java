import java.util.*;

class Count {
    int count = 0;
}
class QueueNode
{
    Node node;
    int horizontalDistance;

    public QueueNode(Node node, int horizontalDistance) {
        this.node = node;
        this.horizontalDistance = horizontalDistance;
    }
}
public class BST {
    Node root;

    public BST() {
        this.root = null;
    }
    public Node insertBST(Node root,int data)
    {
        if(root==null)
            return new Node(data);
        else
        {
            if(root.data > data)
                return insertBST(root.right,data);
            else
                return insertBST(root.left,data);
        }
    }
    public void printBST(Node root)
    {
        if(root!=null)
        {
            System.out.println(root.data);
            printBST(root.left);
            printBST(root.right);
        }
    }
    public void printLeavesBST(Node root)
    {
        if(root!=null)
        {
            if(root.left==null && root.right==null)
            System.out.println(root.data);
            printLeavesBST(root.left);
            printLeavesBST(root.right);
        }
    }
    public void printLeftView(Node root)
    {
        if(root!=null)
        {
            System.out.println(root.data);
            printLeftView(root.left);
        }
    }
    public void printRightView(Node root)
    {
        if(root!=null)
        {
            System.out.println(root.data);
            printRightView(root.right);
        }
    }
    public int heightBST(Node root)
    {
        if(root==null)
            return 0;
        else
        {
                int lHeight = heightBST(root.left) + 1;
                int rHeight = heightBST(root.right)+ 1;
                return Math.max(lHeight,rHeight);
        }
    }
    public int sumHeight(Node root)
    {
        if(root==null)
            return 0;
        else
        {
            int lHeight = heightBST(root.left) + 1;
            int rHeight = heightBST(root.right)+ 1;
            return lHeight+rHeight-1;
        }
    }
    public int diameterBST(Node root)
    {
        if(root==null)
            return 0;
        else
        {
            int option1 = sumHeight(root);
            int option2 = diameterBST(root.left);
            int option3 = diameterBST(root.right);
            return Math.max(option1,Math.max(option2,option3));
        }
    }
    public void kthLargest(Node root,int k,Count c)
    {
        if(root == null || c.count >= k)
        return ;
        else
        {
            kthLargest(root.right,k,c);
            c.count++;
            if(k==c.count) {
                System.out.println(root.data);
                return;
            }
            kthLargest(root.left,k,c);
        }
    }
    public void printBottomView(Node root, TreeMap<Integer,Node> map)
    {
        Queue<QueueNode> q = new LinkedList<>();
        if(root==null)
            return;
        else
        {
            q.add(new QueueNode(root,0));
            while(!q.isEmpty())
            {
                QueueNode temp = q.remove();
                map.put(temp.horizontalDistance,temp.node);
                if(temp.node.left!=null) {
                    q.add(new QueueNode(temp.node.left,temp.horizontalDistance-1));
                    map.put(temp.horizontalDistance - 1, temp.node.left);
                }
                if(temp.node.right!=null) {
                    q.add(new QueueNode(temp.node.right,temp.horizontalDistance+1));
                    map.put(temp.horizontalDistance + 1, temp.node.right);
                }
            }
        }
        map.forEach((integer, node) -> System.out.print(node.data+" "));
    }
    public void printTopView(Node root, TreeMap<Integer,Node> map)
    {
        Queue<QueueNode> q = new LinkedList<>();
        if(root==null)
            return;
        else
        {
            q.add(new QueueNode(root,0));
            while(!q.isEmpty())
            {
                QueueNode temp = q.remove();
                if(!map.containsKey(temp.horizontalDistance))
                map.put(temp.horizontalDistance,temp.node);
                if(temp.node.left!=null) {
                    q.add(new QueueNode(temp.node.left,temp.horizontalDistance-1));
                    if(!map.containsKey(temp.horizontalDistance-1))
                    map.put(temp.horizontalDistance - 1, temp.node.left);
                }
                if(temp.node.right!=null) {
                    q.add(new QueueNode(temp.node.right,temp.horizontalDistance+1));
                    if(!map.containsKey(temp.horizontalDistance+1))
                    map.put(temp.horizontalDistance + 1, temp.node.right);
                }
            }
        }
        map.forEach((integer, node) -> System.out.print(node.data+" "));
    }
    public Node findLCA(Node root,int n1,int n2){
        if(root == null) return null;
        else{
            if(root.data ==n1 || root.data ==n2)
                return root;
            else
            {
                Node left = findLCA(root.left,n1,n2);
                Node right = findLCA(root.right,n1,n2);
                if(left!=null && right!=null) return root;
                if(left == null && right == null) return null;
                return left!=null?left:right;
            }
        }
    }
    public int distanceFromRoot(Node root,int value,int dist){
       if(root == null)
           return -1;
       else{
           if(root.data == value)
               return dist;
           int left = distanceFromRoot(root.left,value,dist+1);
           int right = distanceFromRoot(root.right,value,dist+1);
           if(left!=-1 && right==-1)
               return left;
           else if(right!=-1 && left==-1)
               return right;
           else
               return -1;
       }
    }
    public int distanceBWNodes(Node root,int n1,int n2,int dist){
        return (distanceFromRoot(root,n1,dist)+distanceFromRoot(root,n2,dist)-2*distanceFromRoot(root,findLCA(root,n1,n2).data,dist));
    }
    public String serialize(Node root){
        StringBuffer result = new StringBuffer();
        class Anonymous{
            public StringBuffer fun(Node root){
                if(root == null) {
                    result.append("#,");
                    return result;
                }
                else {
                    result.append(root.data+",");
                    fun(root.left);
                    fun(root.right);
                    return result;
                }
            }
        }
        StringBuffer res = new Anonymous().fun(root);
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
    public Node deserialize(String data) {
        String arr[] = data.split(",");
        Iterator itr = Arrays.asList(arr).iterator();
        class Anonymous {
            public Node fun() {
                if(itr.hasNext()) {
                    String x = itr.next().toString();
                    if (x.equals("#"))
                        return null;
                    Node node = new Node(new Integer(x));
                    node.left = fun();
                    node.right = fun();
                    return node;
                }
                return null;
            }
        }
        return new Anonymous().fun();
    }
    public static void main(String[] args) {
        BST obj = new BST();                                                                //     50
        obj.root = obj.insertBST(obj.root,50);                                         //   /    \
        obj.root.left = obj.insertBST(obj.root,30);                                    //  30     60
        obj.root.left.right = obj.insertBST(obj.root,40);                              //    \    /  \
        obj.root.right = obj.insertBST(obj.root,60);                                   //    40  59  65
        obj.root.right.right = obj.insertBST(obj.root,65);                             //              \
        obj.root.right.left = obj.insertBST(obj.root,59);                              //              100
        obj.root.right.right.right = obj.insertBST(obj.root,100);                      //                \
        obj.root.right.right.right.right = obj.insertBST(obj.root,120);                //                120
//        obj.root.left.left = obj.insertBST(obj.root,29);
//        obj.root.left.left.left = obj.insertBST(obj.root,28);
//        obj.root.left.left.left.left = obj.insertBST(obj.root,27);
//        obj.root.left.left.left.left.left = obj.insertBST(obj.root,26);
//        obj.root.left.left.left.left.left.left = obj.insertBST(obj.root,25);
//        obj.root.left.left.left.left.left.left.left = obj.insertBST(obj.root,24);
        obj.printBST(obj.root);
        System.out.println("Left view of BST");
        obj.printLeftView(obj.root);
        System.out.println("Right view of BST");
        obj.printRightView(obj.root);
        System.out.println("Height of BST "+obj.heightBST(obj.root));
        System.out.println("Diameter of BST "+obj.diameterBST(obj.root));
        System.out.println("Kth largest node ");
        obj.kthLargest(obj.root,2,new Count());
        System.out.println("Print Bottom View of Tree");
        obj.printBottomView(obj.root,new TreeMap<>());
        System.out.println("\nPrint Top View of Tree");
        obj.printTopView(obj.root,new TreeMap<>());
        obj.printLeavesBST(obj.root);
        System.out.println("LCA");
        System.out.println(obj.findLCA(obj.root,60,40).data);
        System.out.println("Distance");
        System.out.println(obj.distanceBWNodes(obj.root,40,120,0));
        System.out.println(obj.serialize(obj.deserialize("1,2,3,#,#,4,5,#,#,#,#")));
    }
}
