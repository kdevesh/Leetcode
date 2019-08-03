import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            map.put(nums[i],i);
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                list.add(i);
                list.add(map.get(target-nums[i]));
                break;
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        System.out.println("Index:");
        System.out.print("[");
        Arrays.stream(obj.twoSum(new int[]{-10,-1,-18,-19}, -19)).forEach(val-> System.out.print(val+" "));
        System.out.print("]");
    }
}
