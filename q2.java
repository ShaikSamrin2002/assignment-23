public class FindingMissingNumber {
    public static void main(String[] args) {
 
        System.out.println("Missing Number: " + findingMissingNumber(array));
    }

    public static int FindingMissingNumber(int[] arr) {
        
        int nextnumber = arr[0] + 1;   /// intialising nextnumber as 1+1=2

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != nextnumber) {  // it will check whether the nextnumber = arr[i] for ex 3 = 2
                return nextnumber;
            }
            nextnumber++;
        }
        return -1;
    }
}
