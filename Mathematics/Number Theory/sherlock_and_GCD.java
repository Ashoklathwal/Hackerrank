import java.io.*;
import java.util.*;

public class sherlock_and_GCD 
 
{

    static public int gcd(int a, int b)
        {
         if(b == 0) return a;
         return gcd(b, a%b); 
        }
    public static void main(String[] args) 
    {
      Scanner sc=new Scanner(System.in);
      int t=sc.nextInt();
      for(int i=0;i<t;i++)
      {
           int n=sc.nextInt();
           int[] arr=new int[n];
           for(int j=0;j<n;j++)
               arr[j]=sc.nextInt();
           int temp=arr[0];
           for(int j=1;j<n;j++)
               {
                 temp = gcd(temp,arr[j]);
               }
          if(temp==1)
              System.out.println("YES");
          else
              System.out.println("NO");
      }  
    }
}