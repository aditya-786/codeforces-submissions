import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int t = sc.nextInt();
        int k = sc.nextInt();
        int d = sc.nextInt();
        
        
        if ( (n-k)<1)
        {
            System.out.println("NO");
        }
        else
        {
            if(d<t)
            {
                System.out.println("YES");
            }
            else
            {
                int time = t;
                int k_raw = k;
                
                while(time<=d)
                {
                    time = time + t;
                    k_raw = k_raw + k;
                }
                
                if(n - k_raw >= 1)
                System.out.println("YES");
                else
                System.out.println("NO");
            }
        }
    }
}