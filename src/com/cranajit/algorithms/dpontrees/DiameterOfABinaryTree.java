package com.cranajit.algorithms.dpontrees;

class Node {
    public Node left;
    public Node right;
    public int value;

    public Node(int value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }
}

class BST {
    public Node root;

    public BST() {
        this.root = null;
    }

    public BST insert(int value) {
        Node node = new Node(value);
        if(this.root == null) {
            this.root = node;
            return this;
        }
        Node current = this.root;

        while(true) {
            if(current.value == value) return this;
            if(current.value < value) {
                if(current.right == null) {
                    current.right = node;
                    return this;
                }
                current = current.right;
            }
            if(current.value > value) {
                if(current.left == null) {
                    current.left = node;
                    return this;
                }
                current = current.left;
            }
        }
    }

    public boolean contains(int value) {
        if(this.root == null) return false;
        if(this.root.value == value) return true;
        Node current = this.root;

        while(true) {
            if(current.value == value) return true;
            if(current.value < value) {
                if(current.right == null) return false;
                current = current.right;
            }
            if(current.value > value) {
                if(current.left == null) return false;
                current = current.left;
            }
        }
    }

    public int find(int value) {
        if(this.root == null) return Integer.MAX_VALUE;
        if(this.root.value == value) return root.value;
        Node current = this.root;

        while(current != null) {
            if(current.value == value) return current.value;
            if(current.value < value) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return Integer.MAX_VALUE;
    }
}

public class DiameterOfABinaryTree {
    static int res = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BST tree = new BST();
        for(int i = 0; i < 15; i ++) {
            if(i % 2 == 0) {
                tree.insert(-i);
            } else {
                tree.insert(i);
            }
        }

        System.out.println(tree.find(2));

        diameterOfaBinaryTree(tree.root);
        System.out.println(res);
    }

    public static int diameterOfaBinaryTree(Node root) {
        if(root == null) {
            return 0;
        }

        int left = diameterOfaBinaryTree(root.left);
        int right = diameterOfaBinaryTree(root.right);

        System.out.println(left + " LEFT " + right + " right ");

        int temp = Math.max(left, right) + 1;
        int ans = Math.max(temp, (right+left+1));
        res = Math.max(ans, res);
        return temp;
    }
}
