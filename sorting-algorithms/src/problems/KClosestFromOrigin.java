package problems;

import java.util.PriorityQueue;

public class KClosestFromOrigin {

  public static void main(String[] args) {
    int [][] input = new int[][] {{1,3} , {-2,2} , {5,8} , {0,1}};
    int K = 2;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for(int i = 0 ; i < input.length ; i++) {
      int init = input[i][0] * input[i][0];
      for(int j = 1 ; j < input[i].length ; j++) {
        pq.offer(init + input[i][j] * input[i][j]);
      }
    }

   for(int i = 0 ; i < K -1 ; i++) {
     pq.poll();
   }
    System.out.println(pq.poll());
  }

}
