import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWord {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        Arrays.sort(words, (str1, str2) -> {
            if (str2.length() != str1.length())
                return str2.length() - str1.length();
            else
                return str1.compareTo(str2);
        });
        for (String word : words) {
            if (isLongest(word, word, set, true, 1))
                return word;
        }
        return "-1";
    }

    private boolean isLongest(String word, String subStr, Set<String> set, boolean isOriginal, int index) {
        if (index == word.length() + 1)
            return true;
        if (!isOriginal && set.contains(subStr))
            return isLongest(word, word.substring(0, index), set, false, index + 1);
        else if (!isOriginal && !set.contains(subStr))
            return false;
        else {
            return isLongest(word, word.substring(0, index), set, false, index + 1);
        }
    }

    public static void main(String[] args) {
        LongestWord obj = new LongestWord();
        String[] words = {"k", "lg", "it", "oidd", "oid", "oiddm", "kfk", "y", "mw", "kf", "l", "o", "mwaqz", "oi", "ych", "m", "mwa"};
        System.out.println(obj.longestWord(words));
    }
}
