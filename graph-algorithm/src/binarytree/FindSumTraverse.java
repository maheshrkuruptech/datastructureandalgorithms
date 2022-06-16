package binarytree;

public class FindSumTraverse {


  static class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int item) {
      data = item;
      left = right = null;
    }
  }

  static boolean isInRange(int data) {
    if(data >=4 & data <= 8) {
      return true;
    }
    return false;
  }
  static int findSum(TreeNode node ) {
    int sum = 0;
    if(node == null) {
      return 0;
    }
    if(isInRange(node.data)) {
      sum+=node.data;
    }
      sum+=findSum(node.left);
      sum+=findSum(node.right);

    return sum;

  }

  public static void main(String[] args) {
    TreeNode node = new TreeNode(6);
    node.left = new TreeNode(4);
    node.right = new TreeNode(8);
    node.right.left = new TreeNode(7);
    node.right.right = new TreeNode(2);
    node.left.left = new TreeNode(3);
    node.left.right = new TreeNode(5);
    System.out.println(findSum(node));

  }
}
