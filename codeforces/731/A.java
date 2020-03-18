import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String s = sc.nextLine();
        
        char [] c = s.toCharArray();
        
        char pointer = 'a';
        
        int count=0;
    
        for(int i=0;i<s.length();i++)
        {
            int ans = Math.abs( (int)pointer - (int)c[i] );
            
            count = count + Math.min(ans, Math.abs(ans-26) );
            
            pointer = c[i];
        }
        
        //System.out.println(  Math.abs((int)pointer - (int)c[0] ) );
        
        System.out.println(count);
        
    }
}