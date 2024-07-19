package com.xavier.leetcode;

import com.xavier.common.TreeNode;

import java.util.LinkedList;

/**
 * 404. 左叶子之和
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 *
 * 示例 1：
 *
 * 输入: root = [3,9,20,null,null,15,7]
 * 输出: 24
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 示例 2:
 *
 * 输入: root = [1]
 * 输出: 0
 *
 * 提示:
 *
 * 节点数在 [1, 1000] 范围内
 * -1000 <= Node.val <= 1000
 */
public class _404_SumOfLeftLeaves {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(sumOfLeftLeavesBFS(root));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return getValueOfLeftLeaf(null, root);
    }

    public int getValueOfLeftLeaf(TreeNode parent, TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null && parent != null && parent.left == node) {
            return node.val;
        } else {
            return getValueOfLeftLeaf(node, node.left) + getValueOfLeftLeaf(node, node.right);
        }
    }

    public static int sumOfLeftLeavesBFS(TreeNode root) {
        LinkedList<TreeNode> childQueue = new LinkedList<>();
        LinkedList<TreeNode> parentQueue = new LinkedList<>();
        parentQueue.offer(root);
        int sum = 0;
        while (!parentQueue.isEmpty() || !childQueue.isEmpty()) {
            TreeNode parent = null;
            int size = 2;
            if (!parentQueue.isEmpty()) {
                parent = parentQueue.poll();
                if (parent.left != null) {
                    childQueue.offer(parent.left);
                }
                if (parent.right != null) {
                    childQueue.offer(parent.right);
                }
            }
            while (!childQueue.isEmpty() && size > 0) {
                TreeNode current = childQueue.poll();
                if (current.left == null && current.right == null && parent != null && parent.left == current) {
                    sum += current.val;
                }
                parentQueue.offer(current);
                size--;
            }
        }
        return sum;
    }

}
