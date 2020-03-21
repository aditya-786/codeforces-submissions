import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        char[] arr = new char[27];
        int c =1;
        
        for(int i=97;i<=122;i++)
        {
            arr[c++] = (char)i;
        }
        
        String s = "";
        c = 1;
        
        for(int i=1;i<=n;i++)
        {
            s = s + arr[c++];
            
            if(c-1 == k)
            c = 1;
        }
        
        System.out.println(s);
    }
}