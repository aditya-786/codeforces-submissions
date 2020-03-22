import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        
        for(int i=0;i<n;i++)
        {
            int max = Math.max(Math.abs(arr[i]-arr[0]),Math.abs(arr[i]-arr[n-1]));
            
            if(i==0)
            {
                System.out.println(Math.abs(arr[i]-arr[i+1])+" "+max);
            }
            
            else if(i == n-1)
            {
                System.out.println(Math.abs(arr[i]-arr[n-2])+" "+max);
            }
            
            else
            {
                System.out.println(Math.min(Math.abs(arr[i]-arr[i-1]),Math.abs(arr[i]-arr[i+1])) +" "+max);
            }
        }
    }
}