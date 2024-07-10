package recursion.experiments;

import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class LeftHandBinaryTree {
    TreeNode root;
    int maxLevel = 0;

    // Recursive function to print the left view
    void leftViewUtil(TreeNode node, int level) {
        // Base Case
        if (node == null) {
            return;
        }

        // If this is the first node of its level
        if (maxLevel < level) {
            System.out.print(node.data + " ");
            maxLevel = level;
        }

        // Recur for left and then right subtree
        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    // A wrapper over leftViewUtil()
    void leftView() {
        leftViewUtil(root, 1);
    }

    public static void main(String[] args) {
        LeftHandBinaryTree tree = new LeftHandBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        tree.root.left.left.left = new TreeNode(8);

        System.out.println("Left view of the binary tree is:");
        tree.leftView();
    }
}
