package algorithm.swordToOffer2.prefixTree;

/**
 * @description: 实现前缀树
 * @author: gaoliang.wang
 * @date: 2022/3/6 3:24 PM
 **/
public class No62 {
    TrieNode root;
    public No62(){
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for (char ch:word.toCharArray()){
            if (node.children[ch-'a'] == null){
                node.children[ch-'a'] = new TrieNode();
            }
            node = node.children[ch-'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word){
        TrieNode node = root;
        for (char ch:word.toCharArray()){
            node = node.children[ch-'a'];
            if (node == null){
                return false;
            }
        }
        return node.isWord;
    }

    public boolean startWith(String prefix){
        TrieNode node = root;
        for (char ch:prefix.toCharArray()){
            node = node.children[ch-'a'];
            if (node == null){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No62 no62 = new No62();
        no62.insert("can");
        no62.insert("very");
        no62.insert("fair");
        no62.insert("family");
        System.out.println(no62.search("a"));
        System.out.println(no62.search("fair"));
        System.out.println(no62.startWith("fa"));
        String str = "abcd";
        System.out.println(str.startsWith("ab"));
    }
}
