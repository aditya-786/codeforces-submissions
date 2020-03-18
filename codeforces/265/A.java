import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        
        String s1 = sc.nextLine();
        char[] c1 = s1.toCharArray();
        
        String s2 = sc.nextLine();
        char[] c2 = s2.toCharArray();
        
        int count = 1;
        int k = 0;
        
        for(int i=0;i<s2.length();i++)
        {
            if(c2[i] == c1[k])
            {
                count++;
                k++;
            }
        }
        
        System.out.println(count);
        
    }
}