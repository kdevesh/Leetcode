import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class PrisonCellAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        ArrayList<int []> result = new ArrayList<>();
        for(int i=0;i<=14;i++)
            result.add(new int[]{});
        for(int i=1;i<=14;i++)
        {
            int output [] = new int [8];
            output[0]=output[7]=0;
            for(int j=1;j<7;j++)
                output[j] = cells[j-1]==cells[j+1]?1:0;
            for(int k=0;k<8;k++)
                cells[k] = output[k];
            result.set(i-1,output);
        }
        return Arrays.stream(result.get((N-1) % 14)).toArray();
    }

    public static void main(String[] args) {
    PrisonCellAfterNDays obj = new PrisonCellAfterNDays();
        Arrays.stream(obj.prisonAfterNDays(new int[]{1,0,0,1,0,0,0,1}, 826)).forEach(val-> System.out.print(val+" "));
    }
}
