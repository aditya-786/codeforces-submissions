import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        int  n = sc.nextInt();
        
        sc.nextLine();
        
        String s = sc.nextLine();
        
        char[] c = s.toCharArray();
        
        int count = 0;
        
        for(int i=0;i<n-1;i++)
        {
            if(c[i] == c[i+1])
            count++;
        }
        
        System.out.println(count);
    }
}