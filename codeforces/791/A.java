import java.util.*;

public class Codeforces
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int Limak_weigh = sc.nextInt();
        int Bob_weigh = sc.nextInt();
        
        int count = 0;
        
        while(Limak_weigh<=Bob_weigh)
        {
            Limak_weigh = Limak_weigh*3;
            Bob_weigh = Bob_weigh*2;
            count++;
            
            if(Limak_weigh>Bob_weigh)
            {
                System.out.print(count);
                break;
            }
        }
    }
}