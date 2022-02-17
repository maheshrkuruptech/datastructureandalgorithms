package array;

import java.util.Arrays;

public class BuildFenwick {
  public static void main(String[] args) {
    int [] array = new int[] {0 , 10,15,20,25,30,35,40,45};
    int [] fenwickArray = make(array);
    System.out.println(getSum( 4, fenwickArray));
  }

  static int[]  make(int [] input) {
     int []T = Arrays.copyOf(input , input.length);

     for(int i = 0 ; i < T.length ; i++) {
       int p = i + (i & -i);
       if(p < input.length) {
         T[p] = T[p] + T[i];
       }
     }
      return T;
  }
  static int getSum(int index , int []T) {
    int sum = 0;
    while(index > 0){
      sum+=T[index];
      index -= index & -index;
    }
    return sum;


  }


  static void updateSum(int index , int k , int []T) {
    while(index < T.length){
      T[index] +=k;
      index += index & -index;
    }
  }
}
