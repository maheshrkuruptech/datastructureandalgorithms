package array;

public class ArrayLengthMinusZeroOne {

    public static void main(String[] args) {
        System.out.println(calculate("01010"));
        System.out.println(calculate("11110000"));
        System.out.println(calculate("1111*0000"));
        System.out.println(calculate("11*10*010"));
    }

    private static int  calculate (String input) {
            char [] data = input.toCharArray();
            int init = 0;
            boolean completed = false;
            while(!completed) {
                if(init + 1 < data.length &&
                    Character.getNumericValue(data[init] )+
                        Character.getNumericValue(data[init + 1] ) == 1) {
                    char [] result = new char[data.length -2];
                    int interim = 0;
                    for(int j = 0 ; j < data.length ; j++) {
                      // collapse the  two elements
                        if(j == init || j == init+1) {
                            continue;
                        }
                        result[interim] = data[j];
                       interim++;
                    }
                    data = result;
                    init = 0;
                } else {
                  init++;
                }
                if(init == data.length || data.length == 0) {
                    completed = true;
                }
            }
            return data.length;
    }
}

