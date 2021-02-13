import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DiagonalTraversalTree {
    static Map<Integer, List<Integer>> out = new HashMap<>();
    public static void diagonalTraversal(TreeNode root,int level)
    {
        if(root==null)
            return;
        List<Integer> temp = out.getOrDefault(level,new ArrayList<>());
        temp.add(root.val);
        out.put(level,temp);
        diagonalTraversal(root.left,level+1);
        diagonalTraversal(root.right,level);
    }
    public static List<Integer> printDiagnoal()
    {
        List<Integer> res = new ArrayList<>();
        out.forEach((k,v) -> {
            res.addAll(v);
            System.out.println(v);
        });
        return res;
    }

    public static void main(String[] args) throws ParseException {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(6);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(7);
        diagonalTraversal(root,0);
        System.out.println(printDiagnoal());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        //sdf.setTimeZone(TimeZone.getTimeZone("IST"));
        SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        //out.setTimeZone(TimeZone.getTimeZone("UTC"));
        //System.out.println(out.format(sdf.parse("2020-08-07T02:38:00-05:00")));

        OffsetDateTime odt = OffsetDateTime.parse( "2020-08-07T02:38:00-05:00" ) ;
        System.out.println(odt.getYear()+" "+odt.getMonthValue()+" "+odt.getDayOfMonth());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
//        OffsetDateTime dateTime = OffsetDateTime.parse(out.format(sdf.parse("2020-08-07T02:38:00-05:00")));
        String finalDate = odt.format(formatter);
        System.out.println(finalDate);
//        System.out.println(dateTime.format(formatter));
//        System.out.println(dateTime.toString());

        String s = "Primera privada&,=& la Joya, ^& Sobre Lago Supe&=&  xyz";
        String x = "abc"+s;
        Arrays.asList(x.split("&=&")).forEach(ele-> System.out.println(ele));
    }
}
