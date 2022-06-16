package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateBalancedString {

    public static void main(String[] args) {
        allBalancedParenthesis(3);
    }

    static List<String> allBalancedParenthesis(int n ) {
        List<String> results = new ArrayList<>();
        solve(n , n, "" , results);
        return results;
    }

    static void solve(int openCount , int closeCount , String output , List<String> results) {
        if(openCount == 0 && closeCount == 0) {
            System.out.println(output);
            results.add(output);
            return;
        }

        if(openCount !=0) {
            System.out.println(openCount + "," + closeCount);
            output+="(";
            openCount--;
            solve(openCount, closeCount, output, results);
        }
        if(closeCount > openCount) {
            System.out.println(openCount + "," + closeCount);
            output+=")";
            closeCount--;
            solve(openCount, closeCount, output, results);
        }


    }
}
