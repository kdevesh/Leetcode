public class SecondLargest {
    private int secondLargest(int [] arr){
        int lar=Integer.MIN_VALUE,secondlar=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>lar){
                secondlar=lar;
                lar=arr[i];
            }
            else if(arr[i]>secondlar)
                secondlar=arr[i];
        }
        return secondlar;
    }
    public static void main(String[] args) {
        SecondLargest obj = new SecondLargest();
        System.out.println(obj.secondLargest(new int [] {1,2,3,4}));
    }
}
