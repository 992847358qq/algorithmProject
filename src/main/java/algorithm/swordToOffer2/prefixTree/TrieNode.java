package algorithm.swordToOffer2.prefixTree;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/3/6 3:28 PM
 **/
public class TrieNode {
    public TrieNode children[];
    boolean isWord;
    int value;
    public TrieNode(){
        children = new TrieNode[26];
    }

}
