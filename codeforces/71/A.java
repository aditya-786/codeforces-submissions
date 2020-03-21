import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int testcases = sc.nextInt();
        sc.nextLine();
        
        while(testcases-- > 0)
        {
           // sc.nextLine();
            
            String s = sc.nextLine();
            
            if(s.length() <= 10)
            {
                System.out.println(s);
            }
            else
            {
                System.out.println(s.substring(0,1)+ (s.length()-2)+s.substring(s.length()-1,s.length()));
            }
        }
    }
}