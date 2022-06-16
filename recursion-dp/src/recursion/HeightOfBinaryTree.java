package recursion;

public class HeightOfBinaryTree {

    public static void main(String[] args) {
        TreeNode n = new TreeNode(5);
        n.left = new TreeNode(6);
        n.left.left = new TreeNode(8);
        n.left.left.left  = new TreeNode(10);
        n.right = new TreeNode(4);
        System.out.println(height(n));
    }

    // Here hypothesis is that , this what function going to do , exactly.
    //
    // Here : this function accepts a node and brings back

    static int height(TreeNode node) {
        // base condition
        if(node == null ) {
            return 0;
        }


    // apply it on smaller input.
        // hypothesis starts
            //height(node.left);
            //height(node.right);
        // hypothesis ends.

        // In the induction phase , we need to get max of both , since o/p is the height of the node.
        // that's the induction phase.
        return 1 + Math.max(height(node.left) , height(node.right)) ;
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
