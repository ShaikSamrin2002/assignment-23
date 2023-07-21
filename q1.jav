import java.util.Scanner;  
public class q1  
  {  
public static void main(String[] args)   
  {  
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
    try {
      if(array[0]!=0) {
      int arrayLength = array.length;
    int cm=1;
    System.out.println("output");
    for (int j = 0; j < n; j++) {
      cm *= array[j];
      array[j] = cm;
      System.out.println(array[j]);
    }
  }
  else {
    System.out.println("Error occured");
  }
  }
    catch (ArithmeticException e) {
      System.out.println("Division by zero error");
    } 
  }  
}  
