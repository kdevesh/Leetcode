import java.util.Arrays;
//Replace each element with the multiplication of all the numbers of the array except self without division.
public class Multiply {
    public void calculate(int arr[]){
        int leftarr[] = new int[arr.length];
        int rightarr []= new int [arr.length];
        leftarr[0]=1;
        rightarr[arr.length-1]=1;
        for(int i=1;i<arr.length;i++)
        {
            leftarr[i] = arr[i-1]*leftarr[i-1];
        }
        for(int i=arr.length-2;i>=0;i--)
        {
            rightarr[i] = arr[i+1]*rightarr[i+1];
        }
        for(int i=0;i<arr.length;i++)
            System.out.print(leftarr[i]*rightarr[i]+" ");
//        Arrays.stream(leftarr).forEach(val -> System.out.print(val+" "));
//        System.out.println();
//        Arrays.stream(rightarr).forEach(val-> System.out.print(val+" "));
    }

    public static void main(String[] args) {
        new Multiply().calculate(new int []{1,2,3,4,5});
    }
}
