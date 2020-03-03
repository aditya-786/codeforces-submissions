import java.util.*;

public class Codeforces
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int problems = sc.nextInt();
        int[] users_surity = new int[3];
        int count = 0;
        int[] count_arr = new int[problems];
        int sum = 0;
        
        for(int i=0;i<problems;i++)
        {
            count = 0;
            
            for(int j=0;j<3;j++)
            {
                users_surity[j] = sc.nextInt();
                
                if(users_surity[j] == 1)
                {
                    count++;
                }
            }
            
            if(count>=2)
            {
                count_arr[i] = 1;
            }
            
            sum = sum + count_arr[i];
        }
        
        System.out.println(sum);
        
    }
}