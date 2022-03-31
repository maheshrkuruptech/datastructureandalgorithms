package knapsack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {


  public static void main(String[] args) {

    List<Integer> parcels
        = new ArrayList<>();
    parcels.add(2);
    parcels.add(3);
    parcels.add(4);
    parcels.add(3);
    parcels.add(3);
    System.out.println(parcels.stream().distinct().count());
    int total = 0 ;
    for(int i = 0 ; i < parcels.size() ; i++) {
      total+= parcels.get(i);
    }
    Collections.sort(parcels);
    System.out.println(solve(parcels , total , parcels.size() -1 ));

    int counter = 0;
    for(int i = 0 ; i < parcels.size(); i++) {
      int parcel = parcels.get(i);
        if(parcel <= 0) {
          continue;
        }
        counter++;
        for(int j = i ; j < parcels.size(); j++) {
          if(parcels.get(j) - parcel >= 0) {
            parcels.set(j , parcels.get(j) - parcel);
          }
        }
    }
    System.out.println(counter);
  }

  static int solve(List<Integer> wt , int capacity , int n) {
   int result  = 0;
  // base criteria
    if(capacity == 0) {
      return 0;
    }
    if(n == 0 && capacity > 0) {
      return 1;
    }
      if (wt.get(n) == wt.get(n - 1)) {
        result += solve(wt, capacity - wt.get(n -1), n -1);
      } else {
        result +=  solve(wt, capacity - wt.get(n), n- 1);
      }

   return result;
  }

}
