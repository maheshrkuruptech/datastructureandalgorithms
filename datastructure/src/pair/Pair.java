package pair;

import java.util.ArrayList;

class Pair{
    public int first;
    public int second;
    
    public Pair(int x, int y){
      this.first = x;
      this.second = y; 
    }
}

class MergeIntervals{
  static ArrayList<Pair> mergeIntervals(ArrayList<Pair> v) {
  
    if(v == null || v.size() == 0) {
      return null;
    }

    ArrayList<Pair> result = new ArrayList<Pair>();

    result.add(new Pair(v.get(0).first, v.get(0).second));

   for (int i = 0 ; i < v.size()  ; i++) {
     int lowerBound = v.get(i).first;
     int upperBound = v.get(i).second;
     int highestPairUpperBound = result.get(result.size() -1).second;

      if(lowerBound <= highestPairUpperBound) {
        result.get(result.size() - 1 ).second  =  Math.max(upperBound , highestPairUpperBound);
      } else {
        result.add(new Pair(lowerBound , upperBound));
      }
   }

    return result;
  }
  public static void main(String[] args) {
    ArrayList<Pair> v = new ArrayList<Pair>();

    v.add(new Pair(1, 2));
    v.add(new Pair(3, 7));
    v.add(new Pair(4, 6));
    v.add(new Pair(6, 8));
    v.add(new Pair(10, 12));
    v.add(new Pair(11, 15));

    ArrayList<Pair> result = mergeIntervals(v);

    for(int i=0; i<result.size(); i++){
      System.out.print(String.format("[%d, %d] ", result.get(i).first, result.get(i).second));
    }
  }
}