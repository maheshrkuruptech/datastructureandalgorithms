
## Dynamic Programming Algorithm

### Bellman Ford
Bellman Ford is a dynamic programming algorithm to find single source the shortest path on a
directed weighted graph.This works well if there is a negative weight edge.
This is done by relaxation method , relaxing all the edges and computing the path.
Time Complexity is O(VE) . In case of complete graph the time complexity is O(n^3).
This is used to detect cycles in weighted directed graph.

DisAdvantage:
This wouldn't work if there is a cycle with total weight is negative.

#### Pseudo code
```
Edge has source , destination and weight 

for(int i = 0 ; i < vertices ; i ++) {
  mark all distance to infinity ; d[V] = max value 
}
d[src] = 0

for(int i = 0 ; i < vertices ; i ++) {
for(j = 0 ; j < edge ; j++) {
  (if d[src] +  cost(src+dest)  < d[dest]) {
        d[dest] =  d[src] +  cost(src+dest);
  }
}

}
```
## Greedy Algorithms


### Dijkstra


### Floyd Warshall


### Ford Fulkerson

### Prims

### Kruskal
