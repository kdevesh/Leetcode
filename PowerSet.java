import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        create(result,nums,lst,0);
        return result;
    }
    public void create(List<List<Integer>> result,int [] nums,List<Integer> lst,int index)
    {
        result.add(new ArrayList<>(lst));
        for(int i=index;i<nums.length;i++)
        {
            lst.add(nums[i]);
            create(result,nums,lst,i+1);
            lst.remove(lst.size()-1);
        }
    }
    public static void main(String[] args) {
        new PowerSet().subsets(new int[]{1,2,3}).forEach(System.out::println);
    }
}
