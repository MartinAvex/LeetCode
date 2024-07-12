package com.xavier.postorderTraversal_145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 *
 * 示例 1：
 *
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 *
 * 提示：
 *
 * 树中节点的数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 */
public class PostorderTraversal {

    public static void main(String[] args) {

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> itemList = new ArrayList<Integer>();
        postorder(root, itemList);
        return itemList;
    }

    public List<Integer> postorderTraversal_01(TreeNode root) {
        ArrayList<Integer> itemList = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode previousNode = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == previousNode) {
                itemList.add(root.val);
                previousNode = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return itemList;
    }

    private void postorder(TreeNode root, List<Integer> itemList) {
        if (root == null) {
            return;
        }
        postorder(root.left, itemList);
        postorder(root.right, itemList);
        itemList.add(root.val);
    }

}
