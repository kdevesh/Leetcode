import java.util.*;
public class AlternateElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T,N;
        T = sc.nextInt();
        while(T!=0){
            N = sc.nextInt();
            long arr [] = new long[N];
            for(int i=0;i<N;i++)
                arr[i]=sc.nextLong();
            int maxIndex = N-1,minIndex=0;
            long maxElement=arr[N-1]+1;
            for(int i=0;i<N;i++)
            {
                if(i%2==0) {
                    arr[i] += (arr[maxIndex] % maxElement) * maxElement;
                    maxIndex--;
                }
                else{
                    arr[i]+=(arr[minIndex]%maxElement)*maxElement;
                    minIndex++;
                }
            }
            for(int i=0;i<N;i++)
                System.out.print(arr[i]/maxElement+" ");
            System.out.println();
            T--;
        }
    }
}
