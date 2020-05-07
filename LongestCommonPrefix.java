class Trie{
   boolean isEnd;
   Trie arr [];
   Trie()
   {
       isEnd = false;
       arr = new Trie[26];
   }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        List<String> res = new ArrayList<>();
        if(strs.length==1)
            return strs[0];
        else if(strs.length==0)
            return "";
        else
        {
            fillTrie(trie,strs[0]);
            for(int i=1;i<strs.length;i++)
            {
                String search = strs[i];
                res.add(getPattern(trie,search));
            }
            Collections.sort(res,(x,y)->{
                return x.length()-y.length();
            });
            return res.get(0);
        }
    }
    private void fillTrie(Trie trie,String word){
        Trie temp = trie;
        for(int i=0;i<word.length();i++)
        {
            int index = word.charAt(i)-'a';
            if(temp.arr[index]==null){
                temp.arr[index] = new Trie();
                temp = temp.arr[index];
            }
        }
        temp.isEnd = true;
    }
    private String getPattern(Trie trie,String word){
        Trie temp = trie;
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
