import java.util.*;
class Trie {

    /** Initialize your data structure here. */
    List<Trie> list;
    boolean isEnd;
    public Trie() {
        list = new LinkedList<>();
        isEnd = false;
        for(int i=0;i<26;i++)
            list.add(null);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curr = this;
        for(int i=0;i<word.length();i++)
        {
            if(curr.list.get(word.charAt(i)-'a')==null)
                curr.list.set(word.charAt(i)-'a',new Trie());
            curr = curr.list.get(word.charAt(i)-'a');
        }
        curr.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curr = this;
        for(int i=0;i<word.length();i++)
        {
            if(curr.list.get(word.charAt(i)-'a')!=null)
                curr = curr.list.get(word.charAt(i)-'a');
            else
                return false;
        }
        return curr.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie curr = this;
        for(int i=0;i<prefix.length();i++)
        {
            if(curr.list.get(prefix.charAt(i)-'a')!=null)
                curr = curr.list.get(prefix.charAt(i)-'a');
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj =  new Trie();
        obj.insert("apple");
        System.out.println(obj.search("apple"));
        System.out.println(obj.search("app"));
        System.out.println(obj.startsWith("app"));
        System.out.println(obj.startsWith("appx"));
    }
}

