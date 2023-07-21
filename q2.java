import java.util.Scanner;

public class FindingMissingNumber {
    public static void main(String[] args) {
         int n;  
    Scanner sc=new Scanner(System.in);  
    System.out.print("Enter the number of elements in array: ");  
    n=sc.nextInt();  
    int[] array = new int[10];  
    System.out.println("Enter the elements of the array: ");  
    for(int i=0; i<n; i++)  
    {  
    array[i]=sc.nextInt();  
    }  
    System.out.println("Array elements are: ");  
    for (int i=0; i<n; i++)   
    {  
    System.out.println(array[i]);  
    } 
 
        System.out.println("Missing Number: " + FindingMissingNumber(array));
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
