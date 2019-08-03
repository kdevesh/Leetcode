import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Kadane {
    public static void main(String[] args) throws Exception{
        BufferedReader dd = new BufferedReader(new InputStreamReader(System.in));
        int T,N;
        T=Integer.parseInt(dd.readLine());
        while(T!=0){
            N = Integer.parseInt(dd.readLine());
            String s = dd.readLine();
            String sarr[] = s.split("\\s");
            int arr [] = new int[N];
            for(int i=0;i<N;i++)
                arr[i]=Integer.parseInt(sarr[i]);
            int maxSoFar=0,max=Integer.MIN_VALUE;
            for(int i=0;i<N;i++) {
                maxSoFar += arr[i];
                if (max < maxSoFar)
                    max = maxSoFar;
                if (maxSoFar < 0)
                    maxSoFar = 0;
            }
            System.out.println(max);
            T--;
        }
    }
}
