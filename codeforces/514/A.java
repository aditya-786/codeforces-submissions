import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String s = sc.nextLine();
        
        char[] array = s.toCharArray();
        
        int x = 0;
        int count = 0;
        
        for(int i=0;i<array.length;i++)
        {
            x = array[i] - '0';
            
            if(9-x<=x && count == 0 && 9-x>0)
            System.out.print(9-x);
            else if(9-x<=x && count == 0 && 9-x==0)
            System.out.print(x);
            else if(9-x<=x)
            System.out.print(9-x);
            else
            System.out.print(x);
            
            count = 1;
        }
    }
}