package recursion.experiments;

public class AllPossibleSubString {
    
    public static void main(String[] args) {
        getAllCombo("ab");
    }

    private  static void getAllCombo(String input) {
            logic("", input);

    }

    private static void logic(String output , String input) {
            if("".equals(input)) {
                if(! "".equals(output)) {
                    System.out.println(output);
                }
                return ;
            }
           logic(output, input.substring(1)); 
           logic(output+input.charAt(0), input.substring(1));
    }


}
