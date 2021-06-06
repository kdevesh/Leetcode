import java.util.HashMap;
import java.util.Map;

public class AlienDictionary {

    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < order.length(); i++)
            dict.put(order.charAt(i), i);
        for (int i = 0; i < words.length - 1; i++) {
            char[] first = words[i].toCharArray();
            char[] second = words[i + 1].toCharArray();
            int lim = Math.min(first.length, second.length);
            int k = 0;
            boolean flag = false;
            while (k < lim) {
                if (first[k] != second[k]) {
                    flag = true;
                    if ((dict.get(first[k]) - dict.get(second[k]))<0)
                       break;
                    else if((dict.get(first[k]) - dict.get(second[k]))>0)
                        return false;
                }
                k++;
            }
            if (!flag && (first.length - second.length) > 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String []arr = {"kuvp","q"};
        String order = "ngxlkthsjuoqcpavbfdermiywz";
        System.out.println(isAlienSorted(arr,order));
    }
}
