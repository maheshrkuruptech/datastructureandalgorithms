import java.util.Map;
import java.util.stream.Collectors;

/**
 * Compare against a standard string that the input is an anagram or not.
 *
 */
public class AnagramChecker {
    public static void main(String[] args) {
        String key = "deposit";
        System.out.println(isAnagram(key.toUpperCase() , "dopiest".toUpperCase()));
        String [] dictionary = new String[]{ "crapy" , "deposit" ,  "elite" , "xenia" };
        //Binary Search comes handy when have the luxury for pre-processing
        //In that case , find all hash , sort the hash in the pre-processing step
        //Look-up is just finding input hash and do a binary search.
        System.out.println(binarySearchInPreProcessed(dictionary , "xenia"));
    }
    static boolean isAnagram(String key , String input) {
            return hashOfString(key).equals(hashOfString(input));
    }

    static String hashOfString(String input) {
        Map<Character , Integer> result  = (input.chars().boxed()
                .collect(Collectors.toMap(k -> Character.valueOf((char) k.intValue()) , v-> 1 , Integer::sum)));
        return  result.entrySet().stream()
                .sorted(Map.Entry.<Character,Integer>comparingByKey().reversed())
                .map(characterIntegerEntry ->
                        characterIntegerEntry.getKey().toString()
                                .concat(String.valueOf(characterIntegerEntry.getValue())))
                .collect(Collectors.joining(""));
    }


    static boolean binarySearchInPreProcessed(String [ ] dictionary  , String input) {
        int left = 0 ;
        int right = dictionary.length - 1 ;

        while(left <= right) {
            int middle = (left + right ) / 2;
            int compareResult = input.compareTo(dictionary[middle]);
            if(compareResult == 0) {
                return true;
            }
            if(compareResult >  0) {
                left = middle + 1;
            } else {
                right = middle - 1 ;
            }
        }

        return false;

    }


}
