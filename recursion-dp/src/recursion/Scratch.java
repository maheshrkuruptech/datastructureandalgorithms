package recursion;

public class Scratch {
    
    public static void main(String[] args) {
        printAll("abc");
    }

    static void printAll(String abc) {
        print(abc , abc);
    
    }

    static void print(String com , String rest) {
        if(com == null || rest == null) {
            return;
          }
             
        System.out.println(com) ;
         System.out.println(com.substring(0  , 1) );  
         System.out.println(com.substring( 1) );   
         print(com.substring(0  , 1) , com.substring(0  , 1) );
         
    }
    


}
