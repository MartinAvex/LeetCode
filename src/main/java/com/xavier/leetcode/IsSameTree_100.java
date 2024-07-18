package com.xavier.leetcode;

import com.xavier.common.TreeNode;

import java.util.*;

/**
 * 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1：
 *
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * 示例 3：
 *
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 *
 * 提示：
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 */
public class IsSameTree_100 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1, null, new TreeNode(2));
        TreeNode q = new TreeNode(1, new TreeNode(2), null);
        System.out.println(isSameTree_BFS(p, q));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        return compareTwoNode(p, q);
    }
    public static boolean compareTwoNode(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        return n1.val == n2.val && compareTwoNode(n1.left, n2.left) && compareTwoNode(n1.right, n2.right);
    }

    public static boolean isSameTree_BFS(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();

        queue1.add(p);
        queue2.add(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode pop1 = queue1.pop();
            TreeNode pop2 = queue2.pop();
            if (pop1.val != pop2.val) {
                return false;
            }
            if (pop1.left != null && pop2.left != null) {
                queue1.add(pop1.left);
                queue2.add(pop2.left);
            } else if (pop1.left != null || pop2.left != null) {
                return false;
            }
            if (pop1.right != null && pop2.right != null) {
                queue1.add(pop1.right);
                queue2.add(pop2.right);
            } else if (pop1.right != null || pop2.right != null) {
                return false;
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

}
