package binarytree;




public class InvertBinaryTree {
  public TreeNode invertTree(TreeNode root) {
    if(root==null){
      return root;
    }

    invertTree(root.left);
    invertTree(root.right);

    TreeNode t = root.left;
    root.left = root.right;
    root.right = t;

    return root;
  }

  public static void main(String[] args) {
    InvertBinaryTree tree = new InvertBinaryTree();
    tree.invertTree(null);
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
