package recursion.experiments;

public class PrintNNumbers {


    public static void main(String[] args) {
        print(7);
    }

    private static void print(int n ) {
        // base condition 
        if(n ==0) {
            return;
        }
        // induction. what to do !! 
        // if we take this step after print(n-1) order of print differs
        // descenting here 
        System.out.println(n);
        // hypothesis , this function takes care
        print(n-1);
        // induciton , ascenting here 
       // System.out.println(n);

       
    }
}
