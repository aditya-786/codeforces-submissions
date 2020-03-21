import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] indexOfOne = new int[n+1];
        int[] indexOfTwo = new int[n+1];
        int[] indexOfThree = new int[n+1];
        int k1 = 0, k2 = 0, k3 = 0;
        
        int[] arr = new int [n+1];
        
        int count1 = 0, count2 = 0, count3 = 0;
        
        for(int i=1;i<=n;i++)
        {
            arr[i] = sc.nextInt();
            
            if(arr[i] == 1)
            {
                indexOfOne[k1] = i;
                count1++;
                k1++;
            }
            
            else if(arr[i] == 2)
            {
                indexOfTwo[k2] = i;
                count2++;
                k2++;
            }
            
            else
            {
                indexOfThree[k3] = i;
                count3++;
                k3++;
            }
        }
        
        int ans = Math.min(count1,count2);
        ans = Math.min(ans,count3);
        
        if(ans == 0)
        System.out.println(ans);
        else
        {
            System.out.println(ans);
            
            for(int i=0;i<ans;i++)
            {
                System.out.println(indexOfOne[i]+" "+indexOfTwo[i]+" "+indexOfThree[i]);
            }
        }
    }
}