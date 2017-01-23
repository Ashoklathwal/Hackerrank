
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Sorting_Bubble_Sort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int a_i=0; a_i < n; a_i++)
           {
            arr[a_i] = in.nextInt();
           }
        int num_of_swaps=0;
        for(int i=0;i<n;i++)
            {
              for(int j=0;j<n-1;j++)
                  {
                    if(arr[j]>arr[j+1])
                        {
                          int temp=arr[j];
                              arr[j]=arr[j+1];
                              arr[j+1]=temp;
                          num_of_swaps++;
                        }
                  } 
            }
        System.out.println("Array is sorted in "+num_of_swaps+" swaps.\nFirst Element: "+arr[0]+"\nLast Element: "+arr[n-1]);
    }
}
