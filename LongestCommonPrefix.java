import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Trie1{
   boolean isEnd;
   Trie1 arr [];
   Trie1()
   {
       isEnd = false;
       arr = new Trie1[26];
   }
}
class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        Trie1 Trie1 = new Trie1();
        List<String> res = new ArrayList<>();
        if(strs.length==1)
            return strs[0];
        else if(strs.length==0)
            return "";
        else
        {
            fillTrie1(Trie1,strs[0]);
            for(int i=1;i<strs.length;i++)
            {
                String search = strs[i];
                res.add(getPattern(Trie1,search));
            }
            Collections.sort(res,(x, y)->{
                return x.length()-y.length();
            });
            return res.get(0);
        }
    }
    private void fillTrie1(Trie1 Trie1,String word){
        Trie1 temp = Trie1;
        for(int i=0;i<word.length();i++)
        {
            int index = word.charAt(i)-'a';
            if(temp.arr[index]==null){
                temp.arr[index] = new Trie1();
                temp = temp.arr[index];
            }
        }
        temp.isEnd = true;
    }
    private String getPattern(Trie1 Trie1,String word){
        Trie1 temp = Trie1;
        String res = "";
        for(int i=0;i<word.length();i++)
        {
            int index = word.charAt(i)-'a';
            if(temp.arr[index]!=null){
                temp = temp.arr[index];
                res = res + word.charAt(i);
            }
            else
                break;
        }
        return res;
    }
}
