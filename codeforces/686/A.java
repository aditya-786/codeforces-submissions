import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        long n = sc.nextInt();
        long d = sc.nextInt();
        long count = 0;
        
        while(n-- > 0)
        {
            char operator = sc.next().charAt(0);
            long amount = sc.nextInt();
            
            if (operator == '+')
            {
                d = d + amount;
            }
            
            else
            {
                if (d - amount >=0)
                d = d - amount;
                else
                count++;
            }
        }
        
        System.out.println(d+" "+count);
    }
}