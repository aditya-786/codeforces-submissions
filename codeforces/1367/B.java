import java.util.*;
import java.io.*;

public class Main
{
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
    
        String next()
        {
            while(st==null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    
        int nextInt()
        {
            return Integer.parseInt(next());
        }
    
        String nextLine()
        {
            String str = "";
        
            try
            {
                str = br.readLine();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    
    public static void main(String[] args) throws java.lang.Exception
    {
        try
        {
            FastReader fr = new FastReader();
            
            int testcases = fr.nextInt();
            
            while(testcases-->0)
            {
                int n = fr.nextInt();
                
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int i=0;i<n;i++)
                list.add(fr.nextInt());
                
                int count = 0;
                int c1=0,c2=0;
                
                for(int i=0;i<n;i++)
                {
                    int ele = list.get(i);
                    
                    if(ele%2==0) c1++;
                    else c2++;
                    
                    if(i%2!=ele%2)
                    count++;
                }
                
                if(c2==n/2 && c1==(n-n/2))
                System.out.println(count/2);
                else
                System.out.println(-1);
            }
        }
        
        catch(Exception e){}
        finally{}
    }
}