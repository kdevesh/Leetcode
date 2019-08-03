import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class MaxSubArr {
    public static void main(String[] args) throws Exception{
        BufferedReader dd = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(dd.readLine());
        int arr[] = new int[n];
        int maxSum=0,maxsofar=0;
        LinkedList<ArrayList<Integer>> result = new LinkedList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        for(int i =0;i<n;i++)
            arr[i] = Integer.parseInt(dd.readLine());
        for(int i=0;i<n;i++)
        {
            if(arr[i]>0) {
                maxsofar += arr[i];
                temp.add(arr[i]);
            }
            else
            {
                if(maxSum<=maxsofar) {
                    result.add(temp);
                    maxSum = maxsofar;
                }
                maxsofar=0;
                temp = new ArrayList<>();
            }
        }
        if(maxSum<=maxsofar)
            result.add(temp);
        result.forEach(x->{x.forEach(y-> System.out.print(y));
            System.out.println();});
    }
}
