import java.util.*;

public class Codeforces
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        sc.nextLine();
        
        String s = sc.nextLine();
        
        char[] c = s.toCharArray();
        
        int count = 0;
        
        for(int i=0;i<c.length;i++)
        {
            if(c[i]=='A')
            count++;
            else
            count--;
        }
        
        if(count>0)
        System.out.println("Anton");
        else if(count<0)
        System.out.println("Danik");
        else
        System.out.println("Friendship");
    }
}