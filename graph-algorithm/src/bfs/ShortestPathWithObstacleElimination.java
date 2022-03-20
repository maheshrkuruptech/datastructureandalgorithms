package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathWithObstacleElimination {

  public static void main(String[] args) {
    int[][] adjacencyMatrix = new int[][]{{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}};
    int m = adjacencyMatrix.length;
    int n = adjacencyMatrix[0].length;
    int[][] navigation = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int k = 1;
    int steps = 0;

    boolean[][][] v = new boolean[m][n][k + 1];

    Queue<int[]> queue = new LinkedList<>();

    queue.offer(new int[]{0, 0, k});

    while (!queue.isEmpty()) {
      int size = queue.size();

      while (size-- > 0) {
        int[] current = queue.poll();
        if (current[0] == m - 1 && current[1] == n - 1) {
          break;
        } else {
          for (int nav = 0; nav < navigation.length; nav++) {
            int i = current[0] + navigation[nav][0];
            int j = current[0] + navigation[nav][1];
            int obs = current[2];

            // Traverse thru cells.
            if (i >= 0 && i < m && j >= 0 && j < n) {
              if (adjacencyMatrix[i][j] == 0 && !v[i][j][obs]) {
                queue.offer(new int[]{i, j, obs});
                v[i][j][obs] = true;
              } else if (adjacencyMatrix[i][j] == 1 && obs > 0 && !v[i][j][obs - 1]) {
                queue.offer(new int[]{i, j, obs - 1});
                v[i][j][obs - 1] = true;
              }
            }
          }
        }
        steps++;
      }

    }

    if(steps == 0 ) {
      System.out.println(-1);
    } else {
      System.out.println(steps);
    }
  }

}
