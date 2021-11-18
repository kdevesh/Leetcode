import java.util.ArrayList;
import java.util.List;

public class PowerSetV2<T> {
    List<List<T>> res = new ArrayList<>();

    public List<List<T>> generatePowerSet(T[] arr) {
        return helper(arr, arr.length);
    }

    private List<List<T>> helper(T[] arr, int len) {
        if (len == 0) {
            res.add(new ArrayList<>());
            return res;
        } else {
            List<List<T>> partialList = helper(arr, len - 1);
            List<List<T>> tempList = new ArrayList<>(partialList);
            T operator = arr[len - 1];
            for (List<T> list : tempList) {
                List<T> tempRes = new ArrayList<>();
                if (!list.isEmpty()) {
                    tempRes.addAll(list);
                    tempRes.add(operator);
                }
                if (tempRes.isEmpty())
                    tempRes.add(operator);
                res.add(tempRes);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        PowerSetV2<Integer> obj = new PowerSetV2<>();
        Integer[] arr = {1, 2, 3};
        List<List<Integer>> res = obj.generatePowerSet(arr);
        System.out.println(res);
    }
}
