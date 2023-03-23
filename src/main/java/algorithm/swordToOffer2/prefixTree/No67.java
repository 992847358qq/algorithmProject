package algorithm.swordToOffer2.prefixTree;

/**
 * @description: 最大的异或
 * @author: gaoliang.wang
 * @date: 2022/3/6 4:40 PM
 **/
public class No67 {
    class TrieNode67{
        TrieNode67[] children;
        public TrieNode67(){
            //只保存0和1
            this.children = new TrieNode67[2];
        }
    }
    //从高位构建前缀树
    public TrieNode67 build(int[] nums){
        TrieNode67 root = new TrieNode67();
        for (int num:nums){
            TrieNode67 node = root;
            for (int i = 31; i >=0 ; i--) {
                int bit = (num>>i) & 1;
                if (node.children[bit] == null){
                    node.children[bit] = new TrieNode67();
                }
                node = node.children[bit];
            }
        }
        return root;
    }

    public int getSum(int[] nums){
        TrieNode67 root = build(nums);
        int max = 0;
        for (int num:nums){
            TrieNode67 node = root;
            int xor = 0;
            for (int i = 31; i >=0 ; i--) {
                int bit = (num>>i)&1;
                //如果高位相邻不等，那么该值异或为最大值
                if (node.children[1-bit] != null){
                    //异或为1，每次加1
                    xor = (xor<<1) +1;
                    node = node.children[1-bit];
                }else {
                    xor = xor << 1;
                    node = node.children[bit];
                }
            }
            //求所有异或中最大值
            max = Math.max(max,xor);
        }
        return max;
    }
}