package array;

public class FindLongestSubArrayBySum {

  public static void main(String[] args) {
    int [] input = new int[] {-2,11,8,9,1,2,3,6,5,7};
    int toMatch = 12;
    longestSubArrayMatchingSum(input , toMatch);
  }

  private static int [] longestSubArrayMatchingSum(int [] input , int toMatch) {
    int sum = 0 ; int left = 0 ; int right = 0; int [] result  = new int[] {-1};
       while( right < input.length) {
         sum+=input[right];

         while(left < right && sum > toMatch) {
           sum-=input[left++];
         }

         if(sum == toMatch && (result.length == 1 || result[1] - result[0] < right - left ) ) {
           result = new int [] {left + 1 , right + 1};
         }
         right++;
       }
        return  result;
  }
}
