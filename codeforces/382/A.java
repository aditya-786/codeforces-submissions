import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String s1 = sc.nextLine();
        
        char[] sequence1 = s1.toCharArray();
        
        int count1 = 0, count2 = 0;
        int raw_count = 0;
        char[] x1 = new char[26];
        char[] x2 = new char[26];
        
        for(int i=0;i<sequence1.length;i++)
        {
            if(sequence1[i] == '|')
            raw_count = 1;
            
            else if(raw_count == 0)
            x1[count1++] = sequence1[i];
            
            else
            x2[count2++] = sequence1[i];
        }
        
        String s2 = sc.nextLine();
        
        char[] sequence2 = s2.toCharArray();
        
        for(char i : sequence2)
        {
            if(count1<count2)
            x1[count1++] = i;
            else
            x2[count2++] = i;
        }
        
        if(count1 == count2)
        {
            for(int i=0;i<count1;i++)
            System.out.print(x1[i]);
            
            System.out.print("|");
            
            for(int i=0;i<count2;i++)
            System.out.print(x2[i]);
        }
        else
        System.out.println("Impossible");
    }
}