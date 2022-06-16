package recursion;

public class AllPossibleSubString {

    public static void main(String[] args) {
        printAllSubString("abc" , "");
    }

    static void printAllSubString(String input , String output) {
        if(input == null || input.equals("") ) {
            if(! output.equals("")) {
                System.out.println(output);
            }
            return;
        }

        printAllSubString(input.length() >= 1 ? input.substring(1) : input, output );

        printAllSubString(input.substring(1) , output+ input.substring(0 ,1));


    }
}
