package algorithm.swordToOffer2.prefixTree;

import java.util.List;

/**
 * @description: 最短的单词编码
 * @author: gaoliang.wang
 * @date: 2022/3/6 4:40 PM
 **/
public class No65 {
    public static void main(String[] args) {
        No65 no65 = new No65();
        String[] words = new String[]{"time","me","bell"};
        System.out.println(no65.minimumLengthEncoding(words));
    }

    public TrieNode buildTrie(String[] dicts){
        TrieNode root = new TrieNode();
        for (String dict:dicts){
            TrieNode node = root;
            for (int i = dict.length()-1; i >=0; i--) {
                char ch = dict.charAt(i);
                if (node.children[ch-'a'] == null){
                    node.children[ch-'a'] = new TrieNode();
                }
                node = node.children[ch-'a'];
            }
        }
        return root;
    }

    public int minimumLengthEncoding(String[] words) {
        TrieNode root = buildTrie(words);
        int total[] = {0};
        dfs(root,1,total);
        return total[0];
    }

    private void dfs(TrieNode root, int length, int[] total) {
        boolean isLeaf = true;
        for (TrieNode child:root.children){
            if (child != null){
                isLeaf = false;
                dfs(child,length +1 ,total);
            }
        }
        if (isLeaf){
            total[0]+=length;
        }
    }
}
