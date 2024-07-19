package com.xavier.leetcode;

import com.xavier.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * 示例 1：
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 示例 5：
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 */
public class _144_PreorderTraversal {

    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> itemList = new ArrayList<Integer>();
        preorder(root, itemList);
        return itemList;
    }

    public List<Integer> preorderTraversal_01(TreeNode root) {
        List<Integer> itemList = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                itemList.add(root.val);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return itemList;
    }

    private void preorder(TreeNode root, List<Integer> itemList) {
        if (root == null) {
            return;
        }
        itemList.add(root.val);
        preorder(root.left, itemList);
        preorder(root.right, itemList);
    }
}
