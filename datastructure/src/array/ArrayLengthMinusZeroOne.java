package array;

public class ArrayLengthMinusZeroOne {

    public static void main(String[] args) {
        System.out.println(calculate("01010"));
        System.out.println(calculate("11110000"));
        

    }

    private static int  calculate (String input) {
            char [] data = input.toCharArray();
            int init = 0;
            boolean completed = false;

            while(!completed) {
                if(init < data.length && init + 1 < data.length && data[init] + data[init+1] == 1) {
                    char [] result = new char[data.length -2];
                    for(int j = 0 ; j < data.length ; j++) {
                        if(j == init || j == init+1) {
                            continue;
                        }
                        result[j] = data[j];
                    }
                    data = result;
                    init = 0;
                }
                if(init == data.length || data.length == 0) {
                    completed = true;
                }
            }


            return 0;
    }
}

