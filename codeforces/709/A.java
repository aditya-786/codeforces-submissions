import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int noOfOranges = sc.nextInt();
        
        int maxOrangeCapacity = sc.nextInt();
        
        int squeezeCapacity = sc.nextInt();
        
        ArrayList <Integer> list = new ArrayList<Integer>();
        
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count = 0;
        
        for(int i=0;i<noOfOranges;i++)
        {
            list.add(sc.nextInt());
            
            if (list.get(i) <= maxOrangeCapacity )
            {
                count = count + list.get(i);
            }
            
            if(count > squeezeCapacity )
            {
                count1++;
                count = 0;
            }
        }
        
        System.out.println(count1);
    }
}