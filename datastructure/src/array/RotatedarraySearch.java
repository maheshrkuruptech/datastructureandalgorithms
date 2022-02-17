package array;

import java.util.List;

public class RotatedarraySearch {

  public int search(final List <Integer> A, int B) {
    int begin = 0, end = A.size() - 1;
    while(begin<=end){
      int mid = (begin + end)/2;
     int midValue = A.get(mid);
     if(midValue == B) {
       return mid;
     }
     int beginValue = A.get(begin);
     int endValue = A.get(end);
     if(beginValue == B) {
       return begin;
     }
     if(endValue == B) {
       return end;
     }
     if(midValue > beginValue) {
       if (B >= beginValue && B< midValue) {
         end = mid -1;
       } else {
         begin = mid +1;
       }
     } else {
       if(B > midValue && B <=endValue) {
         begin = mid +1;
       } else {
         // a  case , 1,2,3,4,5 rotated once 5,1,2,3,4
         end = mid -1;
       }
     }
    }
    return -1;
  }

  public int findMin(final List<Integer> A) {
    int begin = 0, end = A.size() - 1;
    while (begin < end) {
      int mid = (begin + end) / 2;
      int midVal = A.get(mid);
      int beginVal = A.get(begin);
      if (midVal > A.get(mid + 1)) {
        return A.get(mid + 1);
      } else if (midVal > beginVal) {
        begin = mid + 1;
      } else {
        end = mid;
      }
    }
    return A.get(0);
  }
}
