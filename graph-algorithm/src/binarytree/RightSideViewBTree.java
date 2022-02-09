package binarytree;

import algorithm.graphs.btree.InvertBTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideViewBTree {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> view = new ArrayList<>();
    if(root == null ) {
      return view;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while(! queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0 ; i < size ; i++) {
        TreeNode node = queue.remove();
        if(i == size -1) {
          view.add(node.val);
        }

        if(node.left !=null) {
          queue.add(node.left);
        }
        if(node.right !=null) {
          queue.add(node.right);
        }
      }
    }

    return view;

  }
}
