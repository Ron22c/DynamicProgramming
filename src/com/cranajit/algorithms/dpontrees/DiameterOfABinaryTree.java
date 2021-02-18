package com.cranajit.algorithms.dpontrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

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

        List<Integer> datadfsp = tree.dfsPreOrder();
        List<Integer> databfs = tree.bfs();
        List<Integer> datadfsPO = tree.dfsPostOrder();
        List<Integer> datadfsIn = tree.dfsinOrder();

        System.out.println(databfs);
        System.out.println(datadfsp);
        System.out.println(datadfsPO);
        System.out.println(datadfsIn);

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

    public List<Integer> bfs() {
        List<Integer> data = new ArrayList<>();
        Queue<Node> queue = new ConcurrentLinkedQueue<>();

        if(this.root == null) return data;
        Node current = this.root;
        queue.add(current);
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            data.add(temp.value);
            if(temp.left != null) queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
        }
        return data;
    }

    public List<Integer> dfsPostOrder() {
        List<Integer> data = new ArrayList<>();
        if(this.root == null) return data;
        data = transversepost(this.root, data);
        return data;
    }

    public List<Integer> transversepost(Node node, List<Integer> data) {
        if(node.left != null) data =  transversepost(node.left, data);
        if(node.right != null) data =  transversepost(node.right, data);
        data.add(node.value);
        return data;
    }

    public List<Integer> dfsPreOrder() {
        List<Integer> data = new ArrayList<>();
        if(this.root == null) return data;
        data = transversepre(this.root, data);
        return data;
    }

    public List<Integer> transversepre(Node node, List<Integer> data) {
        data.add(node.value);
        if(node.left != null) data =  transversepre(node.left, data);
        if(node.right != null) data =  transversepre(node.right, data);
        return data;
    }

    public List<Integer> dfsinOrder() {
        List<Integer> data = new ArrayList<>();
        if(this.root == null) return data;
        data = transverseIn(this.root, data);
        return data;
    }

    public List<Integer> transverseIn(Node node, List<Integer> data) {
        if(node.left != null) data =  transverseIn(node.left, data);
        data.add(node.value);
        if(node.right != null) data =  transverseIn(node.right, data);
        return data;
    }
}