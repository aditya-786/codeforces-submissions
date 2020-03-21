import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.nextLine();
        
        int[] arr = new int[(s.length()/2)+1];
        
        int k = 0;
        
        for(int i=0;i<s.length();i=i+2)
        {
            arr[k] = Integer.parseInt(s.substring(i,i+1));
            k++;
        }
        
        Arrays.sort(arr);
        
        String s1 = "";
        
        for(int i=0;i<arr.length;i++)
        {
            if (i==arr.length-1)
            s1 = s1 + arr[i];
            else
            s1 = s1 + arr[i] + "+";
        }
        
        System.out.println(s1);
    }
}