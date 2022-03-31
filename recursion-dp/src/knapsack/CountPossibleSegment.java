//package knapsack;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class CountPossibleSegment {
//
//
//  public static void main(String[] args) {
//
//
//    List<Integer> parcels
//        = new ArrayList<>();
//    parcels.add(1);
//    parcels.add(3);
//    parcels.add(6);
//    int counter = 0;
//    // represents first pointer
//    int i = 0;
//
//    // represents second pointer
//    int j = parcels.size() - 1;
//
//    while (i < j) {
//
//      // If we find a pair
//      if (parcels.get(i)  - parcels.get(
//          int
//      ) == X)
//        return 1;
//
//        // If sum of elements at current
//        // pointers is less, we move towards
//        // higher values by doing i++
//      else if (A[i] + A[j] < X)
//        i++;
//
//        // If sum of elements at current
//        // pointers is more, we move towards
//        // lower values by doing j--
//      else
//        j--;
//    }
//    return 0;
//
//    System.out.println(counter);
//  }
//
//}
