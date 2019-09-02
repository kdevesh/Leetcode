import java.util.*;
public class SubsetSum {
    public String findSum(int sum,int [] input)
    {
        int n= input.length;
        boolean result [] [] = new boolean[sum+1][n+1];
        for(int i=0;i<=n;i++)
            result[0][i] = true;
        for(int i=1;i<=sum;i++)
            result[i][0] = false;
        for(int i=1;i<=sum;i++)
        {
            for (int j=1;j<=n;j++)
            {
                result[i][j] = result[i][j-1];
                if(i>=input[j-1])
                    result[i][j]=result[i][j] || result[i-input[j-1]][j-1];
            }
        }
        if(result[sum][n])
            return "YES";
        else
            return "NO";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T= sc.nextInt();
        while(T!=0)
        {
            int size = sc.nextInt();
            int arr [] = new int[size];
            for(int i=0;i<size;i++)
                arr[i] = sc.nextInt();
            int input = sc.nextInt();
            System.out.println(new SubsetSum().findSum(input,arr));
            T--;
        }
    }

}
