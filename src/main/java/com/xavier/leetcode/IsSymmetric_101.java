package com.xavier.leetcode;

import com.xavier.common.TreeNode;

import java.util.Stack;

/**
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 示例 1：
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 */
public class IsSymmetric_101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);

    }

    public boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val && isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }

    public boolean isSymmetricByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            TreeNode q = stack.pop();
            if (p == null && q == null) {
                continue;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            stack.push(p.left);
            stack.push(q.right);
            stack.push(p.right);
            stack.push(q.left);
        }
        return true;
    }



}
