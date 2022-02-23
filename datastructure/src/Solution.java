public class Solution {
    
public static void main(String[] args) {
    System.out.println(rotationalCipher( "All-convoYs-9-be:Alert1." , 4));
}

static String rotationalCipher(String input, int rotationFactor) {
  
    StringBuffer sb = new StringBuffer();
    
    char charOfSmallA = 'a';
    char charOfCapsA = 'A';
    char mode = charOfCapsA;
    
    char [] data = input.toCharArray();
    
    for(int i = 0 ; i < data.length ; i++) {    
        if(Character.isDigit(data[i])) {
          int rotated = (Character.getNumericValue(data[i]) + rotationFactor) % 10;
          sb.append(String.valueOf(rotated));
        } else if (!Character.isLetterOrDigit(data[i])) {
          sb.append(data[i]);
        } else {
            mode = charOfCapsA;
            if(Character.isLowerCase(data[i])) {
                mode = charOfSmallA;
            }
            int originalAlphabetPosition = data[i] - mode;
            int newAlphabetPosition = (originalAlphabetPosition + rotationFactor) % 26;
            char newCharacter = (char) (mode + newAlphabetPosition);
            sb.append(newCharacter);
        }
      
    }
      
    return sb.toString();
  }
}


