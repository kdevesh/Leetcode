import java.util.Scanner;

public class InversionArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T,N;
        T = sc.nextInt();
        while(T!=0)
        {
            N = sc.nextInt();
            int arr[]= new int[N];
            int index1=0,index2,end1,end2,inversion=0;
            if(N%2==0)
                index2=N/2-1;
            else
                index2=N/2;
            for(int i=0;i<N;i++)
                arr[i]=sc.nextInt();
            end1=index2;
            end2=N;
            while(index1<end1&&index2<end2){
                if(arr[index1]>arr[index2]){
                    inversion+=end1-index1;
                    index2++;
                }
                else
                    index1++;
            }
            System.out.println(inversion);
            T--;
        }
    }
}
