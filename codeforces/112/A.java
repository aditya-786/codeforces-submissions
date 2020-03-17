import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        
        String s1 = (sc.nextLine()).toLowerCase();
        String s2 = (sc.nextLine()).toLowerCase();
        
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        
        int i;
        
        for(i=0;i<arr1.length;i++)
        {
            if(arr1[i] > arr2[i])
            {
                System.out.println(1);
                break;
            }
            else if(arr1[i] < arr2[i])
            {
                System.out.println(-1);
                break;
            }
        }
        
        if(i==arr1.length)
        System.out.println(0);
    }    
}