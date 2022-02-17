package array;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BitMapping {
    public static void main(String[] args) {
        int size = 10;
        int min = 10;
        int max = 15000;

        List<Integer> randList = new Random().ints(size, min, max)
                .boxed().collect(Collectors.toList());

        int [] data = new int[max];

        // In-memory operation

        for (int i = 0 ; i < randList.size() ; i++) {
            data[randList.get(i)] = 1;
        }

        for (int i = 0 ; i < data.length ; i ++) {
            if(data[i] == 1)
                System.out.println(i);
        }



    }
}
