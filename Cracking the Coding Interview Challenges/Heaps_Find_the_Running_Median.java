
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Heaps_Find_the_Running_Median 
{   
   public static void addNumber(int number,PriorityQueue<Integer> left,PriorityQueue<Integer> right)
        { 
          if(left.size()==0 || number<left.peek())
              left.offer(number);
          else
              right.offer(number);
        }
    public static void rebalanceHeap(PriorityQueue<Integer> left, PriorityQueue<Integer> right)
        {
          PriorityQueue<Integer> biggerHeap = left.size() > right.size() ? left : right;
          PriorityQueue<Integer> smallerHeap = left.size() > right.size() ? right : left;
          if(biggerHeap.size() - smallerHeap.size() >=2)
              smallerHeap.offer(biggerHeap.poll());
        /*  if((biggerHeap.size()!=0 && smallerHeap.size()!=0) && (biggerHeap.peek()>smallerHeap.peek()))
              {
              left=biggerHeap;
              right=smallerHeap;
              }
          else
              {
               right=biggerHeap;
               left=smallerHeap;
              }
              */
        }
    public static double getMedian(PriorityQueue<Integer> left, PriorityQueue<Integer> right)
        {
        PriorityQueue<Integer> biggerHeap = left.size() > right.size() ? left : right;
          PriorityQueue<Integer> smallerHeap = left.size() > right.size() ? right : left;
         if(biggerHeap.size() == smallerHeap.size())
             {
            // System.out.println(biggerHeap.peek()+" "+smallerHeap.peek());
             return ((double)biggerHeap.peek() + smallerHeap.peek())/2;
             }
         else
             return biggerHeap.peek();
        }
    public static double[] getMedians(int[] arr)
        {
         PriorityQueue<Integer> left=new PriorityQueue<Integer>(1,Collections.reverseOrder());
         PriorityQueue<Integer> right=new PriorityQueue<Integer>();
         double[] median=new double[arr.length];
         for(int i=0;i<arr.length;i++)
             {
               int number=arr[i];
               addNumber(number,left,right);
               rebalanceHeap(left,right);
               median[i]=getMedian(left,right);
             }
        return median;
        }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
       // double[] med=new double[a.length];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
       double[] med = getMedians(a);
        //System.out.println(Arrays.toString(med));
        for(int i=0;i<a.length;i++)
            System.out.println(med[i]);
    }
}
