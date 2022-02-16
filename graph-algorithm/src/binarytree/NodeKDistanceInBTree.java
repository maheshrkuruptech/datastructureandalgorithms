package binarytree;

import java.util.*;

class NodeKDistanceInBTree {
  Map<TreeNode, TreeNode> parent;

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    parent = new HashMap();

    // First do a recursive DFS to create a Map of parent for the traversal
    dfs(root, null);

    // Init a BFS.
    Queue<TreeNode> queue = new LinkedList();
    queue.add(null);
    queue.add(target);

    // Since not visited in the data structure , keeping a set.
    Set<TreeNode> seen = new HashSet();
    seen.add(target);
    seen.add(null);

    int dist = 0;

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      if (node == null) {
        if (dist == K) {
          List<Integer> ans = new ArrayList();
          for (TreeNode n: queue)
            ans.add(n.val);
          return ans;
        }
        queue.offer(null);
        dist++;
      }

      else {
        // traverse thru left
        if (!seen.contains(node.left)) {
          seen.add(node.left);
          queue.offer(node.left);
        }
        // traverse thru right
        if (!seen.contains(node.right)) {
          seen.add(node.right);
          queue.offer(node.right);
        }
        TreeNode par = parent.get(node);
        if (!seen.contains(par)) {
          seen.add(par);
          queue.offer(par);
        }
      }
    }

    return new ArrayList<Integer>();
  }

  public void dfs(TreeNode node, TreeNode par) {
    if (node != null) {
      parent.put(node, par);
      dfs(node.left, node);
      dfs(node.right, node);
    }
  }
   
    // Driver program to test the above functions 
    public static void main(String args[]) {
        NodeKDistanceInBTree tree = new NodeKDistanceInBTree();
        tree.distanceK(null , null , 2);
    }
  static class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int item)
    {
      val = item;
      left = right = null;
    }
  }
} 