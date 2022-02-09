public class StringRotation {
    public static void main(String[] args) {
            String candidate =  "abcdefgh";
            int rotateTo = 3;
            String firstComplement = reverseByIndex(candidate , 0 , rotateTo);
            String secondComplement = reverseByIndex(candidate ,  rotateTo , candidate.length() );
            System.out.println(reverseByIndex(firstComplement.concat(secondComplement) , 0 , candidate.length()  ));
    }

    public static  String reverseByIndex(String input , int beginIndex , int endIndex) {
        StringBuilder input1 = new StringBuilder();
        return input1.append(input, beginIndex, endIndex).reverse().toString();
    }
}
