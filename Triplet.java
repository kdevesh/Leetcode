import java.util.*;
public class Triplet {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int T;
        T = sc.nextInt();
        while(T!=0){
            int N;
            N = sc.nextInt();
            int arr [] = new int [N];
            for(int i=0;i<N;i++)
                arr[i]=sc.nextInt();
            Arrays.sort(arr);
            Map<Integer,Integer> map = new HashMap<>();
            int count=0;
            for(int i=0;i<N;i++)
                map.put(arr[i],1);
            for(int i=0;i<N;i++)
            {
                for(int j=i+1;j<N;j++)
                {
                    if(map.containsKey(arr[i]+arr[j]))
                        count++;
                }
            }
            if(count>0)
            System.out.println(count);
            else
                System.out.println("-1");
            T--;
        }
    }
}
