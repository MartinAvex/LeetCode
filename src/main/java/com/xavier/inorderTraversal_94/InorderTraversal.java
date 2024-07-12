package com.xavier.inorderTraversal_94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * 示例 1：
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
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
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *

 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        List<Integer> integers = inorderTraversal(root);
        System.out.println(integers);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> itemList = new ArrayList<Integer>();
        if (root == null) {
            return itemList;
        }
        if (root.left != null && root.right != null) {
            itemList.addAll(inorderTraversal(root.left));
            itemList.add(root.val);
            itemList.addAll(inorderTraversal(root.right));
        } else if (root.left != null) {
            itemList.addAll(inorderTraversal(root.left));
            itemList.add(root.val);
        } else if (root.right != null) {
            itemList.add(root.val);
            itemList.addAll(inorderTraversal(root.right));
        } else {
            itemList.add(root.val);
        }
        return itemList;
    }

    public static List<Integer> inorderTraversal_01(TreeNode root) {
        ArrayList<Integer> itemList = new ArrayList<Integer>();
        inorder(root, itemList);
        return itemList;
    }

    public static List<Integer> inorderTraversal_02(TreeNode root) {
        List<Integer> itemList = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            itemList.add(root.val);
            root = root.right;
        }
        return itemList;
    }

    private static void inorder(TreeNode root, List<Integer> itemList) {
        if (root == null) {
            return;
        }
        inorder(root.left, itemList);
        itemList.add(root.val);
        inorder(root.left, itemList);
    }

}
