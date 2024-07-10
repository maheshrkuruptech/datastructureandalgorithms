package binarytree;




public class InvertBinaryTree {
  private static  TreeNode invertTree(TreeNode root) {
    if(root==null){
      return root;
    }

      // Swap the left and right children
      TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;

      // Recursively invert the children
      invertTree(root.left);
      invertTree(root.right);

    return root;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);

    System.out.println("Original Tree:");
    printTree(root);
    invertTree(root);
    System.out.println("\nInverted Tree:");
    printTree(root);
  }

  public static void printTree(TreeNode root) {
    if (root != null) {
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }
}
  static class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int item) {
      val = item;
      left = right = null;
    }
  }
}
