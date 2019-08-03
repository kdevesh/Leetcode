import java.util.*;
public class SubArrSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int T;
        T = sc.nextInt();
        while(T!=0)
        {
            int N,S;
            N=sc.nextInt();
            S=sc.nextInt();
            int arr [] = new int [N];
            for(int i=0;i<N;i++)
                arr[i]=sc.nextInt();
            int start=0,end=1,temp=arr[0],f=0;
            while(start<N&&end<N)
            {
                if(arr[end]+temp<S)
                {
                    temp+=arr[end];
                    end++;
                }
                else if(arr[end]+temp>S)
                {
                    temp-=arr[start];
                    start++;
                }
                else{
                    f=1;
                    break;
                }
            }
            if(f==1)
                System.out.println(start+1+" "+(end+1));
            else
                System.out.println("-1");
            T--;
        }
    }
}
