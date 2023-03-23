package algorithm.swordToOffer2.prefixTree;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/3/6 4:11 PM
 **/
public class No63 {
    public static void main(String[] args) {
        No63 no63 = new No63();
        List<String> dict = Arrays.asList("cat","bat","rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(no63.replaceWord(dict,sentence));
    }



    public TrieNode buildTrie(List<String> dicts){
         TrieNode root = new TrieNode();
         for (String dict:dicts){
             TrieNode node = root;
             for (char ch:dict.toCharArray()){
                 if (node.children[ch-'a'] == null){
                     node.children[ch-'a'] = new TrieNode();
                 }
                 node = node.children[ch-'a'];
             }
             node.isWord = true;
         }
         return root;
    }

    public String findPrefix(TrieNode root,String word){
        TrieNode node = root;
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch:word.toCharArray()){
            if (node.children[ch-'a'] == null || node.isWord){
                break;
            }
            stringBuilder.append(ch);
            node = node.children[ch-'a'];
        }
        return node.isWord?stringBuilder.toString():"";
    }

    public String replaceWord(List<String> dict,String sentence){
        TrieNode root = this.buildTrie(dict);
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String prefix = this.findPrefix(root, words[i]);
            if (!prefix.isEmpty()){
                words[i] = prefix;
            }
        }
        return String.join(" ",words);
    }


}
