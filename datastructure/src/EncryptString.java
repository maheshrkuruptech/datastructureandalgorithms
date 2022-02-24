public class EncryptString {

    public static void main(String [] args) {
        System.out.println(findEncryptedWord("abc")); // bac
        System.out.println(findEncryptedWord("abcd")); //bacd
        System.out.println(findEncryptedWord("abcxcba")); //xbacbca
        System.out.println(findEncryptedWord("facebook")); //eafcobok
    }
    static String findEncryptedWord(String s) {
        // Write your code here
        char [] data = s.toCharArray();
        char [] result = new char[data.length];
        encrypt(data , 0 , data.length -1 , result , 0); 
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < result.length ; i++) {
          sb.append(result[i]);
        }
        return sb.toString();
      }
      
      static void encrypt(char [] input ,  int low , int high , char[] result, int index) {
        int partition = (int)Math.ceil((low + high) /2);
        if(index <= input.length -1) {
          result[index] = input[partition];
           index++;
          encrypt(input , low , partition -1 , result , index);
          encrypt(input , partition+1 , high , result , index);
        }

      }
}
