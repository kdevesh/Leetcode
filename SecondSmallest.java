public class SecondSmallest {
    private int getSecondMin(int [] arr){
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int j : arr) {
            if (min > j) {
                secondMin = min;
                min = j;
            } else if (j!=min && secondMin > j)
                secondMin = j;

        }
        return secondMin;
    }
    public static void main(String[] args) {
        int [] arr ={10,3,5,1,0,-9,-9};
        System.out.println(new SecondSmallest().getSecondMin(arr));
    }
}
