package com.cranajit.algorithms.dpontrees;

public class MaximumPathSum {
    static int res = Integer.MIN_VALUE;
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(2);
        tree.insert(-1);
        tree.insert(23);

        maxPathSum(tree.root);
        System.out.println(res);
    }

    public static int maxPathSum(Node root) {
        if(root == null) {
            return 0;
        }

        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);

        int temp = Math.max(Math.max(left, right) + root.value, root.value);
        int ans = Math.max(temp, left+right+1);
        res = Math.max(res, ans);

        return temp;
    }
}
