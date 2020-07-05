public class Week2Practise {
    /**
     *
     * 题1：
     * 判断两个单词是否为字母异位词
     * 标签：哈希映射
     * 首先判断两个字符串长度是否相等，不相等则直接返回 false
     * 若相等，则初始化 26 个字母哈希表，遍历字符串 s 和 t
     * s 负责在对应位置增加，t 负责在对应位置减少
     * 如果哈希表的值都为 0，则二者是字母异位词
     *
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/valid-anagram/solution/hua-jie-suan-fa-242-you-xiao-de-zi-mu-yi-wei-ci-by/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s,String t){
        if (s.length() != t.length()){
            return false;
        }
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a'] ++;
            alpha[t.charAt(i) - 'a'] --;
        }
        for (int i = 0;i < 26;i++){
            if (alpha[i] != 0){
                return false;
            }
        }
        return true;
    }
}

