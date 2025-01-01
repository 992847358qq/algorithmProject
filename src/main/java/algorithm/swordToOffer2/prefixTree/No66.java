package algorithm.swordToOffer2.prefixTree;

/**
 * @description: 单词之和
 * 初始化前缀树，字符串保存其值。默认值是0，最后一个字符保存字符串值
 * 找到匹配前缀，先找到当前前缀所在节点。以该节点，向下遍历找到关联字符串值做加和
 * @author: gaoliang.wang
 * @date: 2022/3/6 4:40 PM
 **/
public class No66 {
    TrieNode root;
    public No66(){
        this.root = new TrieNode();
    }

    public void insert (String key,int val){
        TrieNode node = root;
        for (char ch:key.toCharArray()){
            if (node.children[ch-'a'] == null){
                node.children[ch-'a'] = new TrieNode();
            }
            node = node.children[ch-'a'];
        }
        node.value = val;
    }

    public int getSum(TrieNode node){
        if (node == null){
            return 0;
        }
        int result = node.value;
        for (TrieNode child:node.children){
            result+=getSum(child);
        }
        return  result;
    }


}
