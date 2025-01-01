package algorithm.swordToOffer2.prefixTree;

/**
 * @description: 神奇的字典
 * @author: gaoliang.wang
 * @date: 2022/3/6 4:39 PM
 **/
public class No64 {
    TrieNode root;

    //构建前缀树
    public void buildTrie(String[] dict){

    }

    public boolean search(String word){
        return dfs(root,word,0,0);
    }
    //ac ab

    /**
     *
     * @param root 字典节点
     * @param word 单词
     * @param i 单词坐标
     * @param edit 修改次数
     * @return
     */
    private boolean dfs(TrieNode root, String word, int i, int edit) {
        if (root == null){
            return false;
        }
        if (root.isWord && i == word.length() && edit == 1){
            return true;
        }
        if (i<word.length() && edit<=1){
            boolean found = false;
            for (int j = 0; j < 26 && !found; j++) {
                int next = j == word.charAt(i) - 'a'?edit:edit+1;
                found = dfs(root.children[j],word,i+1,next);
            }
            return found;
        }
        return false;
    }
}
