package array;

import java.util.Arrays;

public class MoveZerosToLeft {

  public static void main(String[] args) {
    int [ ] input = new int[] {1,10,20,0,53,63,0,88,0};

    int writeIndex = input.length - 1, readIndex = input.length - 1;

    // sort all non-zero ; keeping the count of zeros in the writeIndex variable.
    while(readIndex >= 0) {
        if(input[readIndex] !=0) {
           input[writeIndex] = input[readIndex];
          writeIndex--;
        }
      readIndex--;
    }

    // fill-in all the index with zero
    while(writeIndex >=0) {
      input[writeIndex] = 0;
      writeIndex--;
    }


    Arrays.stream(input)
        .boxed()
        .forEach(integer -> {
              System.out.print(integer + ",");
            });
    
   }

    
  }





