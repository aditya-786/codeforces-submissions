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
                String s = fr.nextLine();
                char[] c = s.toCharArray();
                
                if(c.length<=2)
                System.out.println(s);
                else
                {
                    s = "";
                    
                    for(int i=0;i<c.length;i++)
                    {
                        if(i==0)
                        s = s+c[i];
                        else if(i==c.length-1)
                        s=s+c[i];
                        else
                        {
                            if(i%2!=0)
                            s=s+c[i];
                        }
                    }
                    System.out.println(s);
                }
            }
        }
        
        catch(Exception e){}
        finally{}
    }
}




