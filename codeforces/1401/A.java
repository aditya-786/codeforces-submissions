//import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;
import java.math.*;
// import java.util.stream.Collectors;
// import java.util.stream.IntStream;

public class Main {
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

        boolean hasNext()
        {
            return next()!=null;
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

    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

    static long MOD = (long) (1e9 + 7);

    static long powerLL(long x, long n)
    {
        long result = 1;
        while (n > 0)
        {
            if (n % 2 == 1)
            {
                result = result * x % MOD;
            }
            n = n / 2;
            x = x * x % MOD;
        }
        return result;
    }

    static long powerStrings(String sa, String sb)
    {
        long a = 0, b = 0;

        for (int i = 0; i < sa.length(); i++)
        {
            a = (a * 10 + (sa.charAt(i) - '0')) %
                    MOD;
        }

        for (int i = 0; i < sb.length(); i++)
        {
            b = (b * 10 + (sb.charAt(i) - '0')) %
                    (MOD - 1);
        }

        return powerLL(a, b);
    }

    static long gcd(long a, long b)
    {
        if (a==0) return b;
        else return gcd(b%a,a);
    }

    static long lcm(long a, long b)
    {
        return (a*b)/gcd(a,b);
    }

    static int lower_bound(List<Integer> list, int k)
    {
        int s = 0;
        int e = list.size();

        while (s!=e)
        {
            int mid = (s+e)>>1;

            if (list.get(mid)<k) s = mid+1;
            else e = mid;
        }

        if (s == list.size()) return -1;
        return s;
    }

    static int upper_bound(List<Integer> list, int k)
    {
        int s = 0;
        int e = list.size();

        while (s!=e)
        {
            int mid = (s+e)>>1;

            if (list.get(mid)<=k) s = mid+1;
            else e = mid;
        }

        if (s == list.size()) return -1;
        return s;
    }

    static int solution(int n , int k)
    {
        if(k==0)
        {
            if(n%2==0) return 0;
            else return 1;
        }
        
        if(n==0)
        {
            return k;
        }
        
        if(k == n) return 0;
        
        if(n>k)
        {
            if(n%2==k%2) return 0;
            else return 1;
        }
        
        return Math.abs(n-k);
    }

    public static void main(String[] args) throws java.lang.Exception
    {
        try {

            FastReader fr = new FastReader();
            //Reader fr = new Reader();
            PrintWriter out = new PrintWriter(System.out);

            int testcases = fr.nextInt();

            while (testcases-->0)
            {
                int n = fr.nextInt();
                int k = fr.nextInt();
                
                out.println(solution(n,k));
            }

            out.flush();
            out.close();
        }

        catch(Exception e){e.printStackTrace();}
        finally{}
    }
}


//(()) () (()((()()()())))