package com.xavier.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal {

    public static void main(String[] args) {

    }

    private List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> itemList = new ArrayList<Integer>();
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

    private List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> itemList = new ArrayList<Integer>();
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

    private List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> itemList = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode previousNode = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right!= null && root.right != previousNode) {
                stack.push(root);
                root = root.right;
            } else {
                itemList.add(root.val);
                previousNode = root;
                root = null;
            }
        }
        return itemList;
    }

}
