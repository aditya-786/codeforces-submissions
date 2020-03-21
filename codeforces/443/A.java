import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        String set = sc.nextLine();
        
        if(set.length() > 3)
        {
            String s = "";
            
            s = s + set.substring(1,2);
            
            char[] count = new char[123];
            
            count[(int)s.charAt(0)]++;
            
            int k = 1;
            
            for(int i=4;i<=set.length();i=i+3)
            {
                s = s + set.substring(i,i+1);
                
                count[(int)s.charAt(k)]++;
                k++;
            }
            
            k = 0;
            
            for(int i : count)
            {
                if(i>0)
                k++;
            }
    
            System.out.println(k);
        }
        
        else if(set.length()==3)
        {
            System.out.println(1);
        }
        else
        {
            System.out.println(0);
        }
    }
}