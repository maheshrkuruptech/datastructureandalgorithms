package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BFSGivenAdjacencyMetrics {
  // Function to perform breadth first search
  static void breadthFirstSearch(int[][] matrix, int source){
    // here we need array since its not  a DS , but plain 2D array
    boolean[] visited = new boolean[matrix.length];
    // make first visited
    visited[source-1] = true;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);
    System.out.println("The breadth first order is");
    while(!queue.isEmpty()){
      // Just to print
      System.out.println(queue.peek());
      // take and also remove from the queue.
      int x = queue.poll();
      for(int i=0; i<matrix.length;i++){
          if(matrix[x-1][i] == 1 && visited[i] == false){
          queue.add(i+1);
          visited[i] = true;
        }
      }
    }
  }

  static void checkIfGraphIsConnected(int adjacency_matrix[][], int source) {
    Queue<Integer> queue = new LinkedList<>();
    int number_of_nodes = adjacency_matrix[source].length - 1;
    int[] visited = new int[number_of_nodes + 1];
    int i, element;
    visited[source] = 1;
    queue.add(source);

    while (!queue.isEmpty())
    {
      element = queue.remove();
      i = element;
      while (i <= number_of_nodes)
      {
        if (adjacency_matrix[element][i] == 1 && visited[i] == 0)
        {
          queue.add(i);
          visited[i] = 1;
        }
        i++;
      }
    }
    boolean connected = false;

    for (int vertex = 1; vertex <= number_of_nodes; vertex++)
    {
      if (visited[vertex] == 1)
      {
        connected = true;
      } else
      {
        connected = false;
        System.out.println("The graph is disconnected");
        break;
      }
    }

    if (connected)
    {
      System.out.println("The graph is connected");
    }
  }
  // Function to read user input
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int vertices;
    System.out.println("Enter the number of vertices in the graph");
    try{
      vertices = Integer.parseInt(br.readLine());
    }catch(IOException e){
      System.out.println("An error occurred");
      return;
    }
    // Create an n*n matrix based on the input.
    // This will be later used to map the link between vertices.
    int[][] matrix = new int[vertices][vertices];
    System.out.println("Enter the adjacency matrix");
    int i,j;
    for(i=0; i<vertices; i++){
      for(j=0; j<vertices; j++){
        try{
          // read all values and fill in .
          matrix[i][j] = Integer.parseInt(br.readLine());
        }catch (IOException e){
          System.out.println("An error occurred");
        }
      }
    }
    int source;
    System.out.println("Enter the source vertex");
    try{
      source = Integer.parseInt(br.readLine());
    }catch(IOException e){
      System.out.println("An error occurred");
      return;
    }



    breadthFirstSearch(matrix,source);

    // BFS ; visited node to 1. In the end if any is not visited , its not connected.

    checkIfGraphIsConnected(matrix,source);
  }
}