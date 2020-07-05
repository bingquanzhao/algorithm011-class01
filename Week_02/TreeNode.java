import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }



    public class Solution {
        /**
         * 前序遍历
         * 从根节点开始，每次迭代弹出栈顶元素，将其孩子节点压入占中，先压右孩子再压左孩子
         * 进栈顺序就决定了前中后序
         * @param root
         * @return
         */
        public List<Integer> preorderTraversal(TreeNode root){
            LinkedList<TreeNode> stack = new LinkedList<>();
            LinkedList<Integer> output = new LinkedList<>();
            if (root == null) {
                return output;
            }
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pollLast();
                output.add(node.val);
                //右节点先压栈，最后处理
                if (node.right != null){
                    stack.add(node.right);
                }
                if (node.left != null){
                    stack.add(node.left);
                }
            }
            return output;
        }
        public List<Integer> inorderTraversal(TreeNode root){
            List<Integer> list = new ArrayList<Integer>();

            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode cur = root;

            while(cur!=null || !stack.empty()){
                while(cur!=null){
                    stack.add(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }

            return list;
        }


    }

}

