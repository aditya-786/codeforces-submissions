import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int a[] = new int[5];
        
        a[1] = sc.nextInt();
        a[2] = sc.nextInt();
        a[3] = sc.nextInt();
        a[4] = sc.nextInt();
        
        sc.nextLine();
        
        String s = sc.nextLine();
        
       // char c1 [] = s.toCharArray();
        int[] c = new int[s.length()];
        
        for(int i=0;i<s.length();i++)
        {
            c[i] = s.charAt(i) - '0';
        }
        
        
        int sum = 0;
        
        for(int i=0;i<c.length;i++)
        {
            sum = sum + a[c[i]];
        }
        
        System.out.println(sum);
    }
}