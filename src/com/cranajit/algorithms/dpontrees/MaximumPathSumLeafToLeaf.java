package com.cranajit.algorithms.dpontrees;

public class MaximumPathSumLeafToLeaf {
    static int res = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(2);
        tree.insert(-1);
        tree.insert(23);

        maxPathSumLtoL(tree.root);
        System.out.println(res);
    }

    public static int maxPathSumLtoL(Node root) {
        if(root == null) return 0;

        int left = maxPathSumLtoL(root.left);
        int right = maxPathSumLtoL(root.right);

        int temp = Math.max(left, right) + root.value;

        if(root.left == null && root.right == null) {
            temp = Math.max(temp, root.value);
        }

        int ans = Math.max(temp, left+right+root.value);
        res = Math.max(ans, res);
        return temp;
    }
}
