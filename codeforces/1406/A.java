import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
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

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
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

    static long formula(long n, long r)
    {
        long p = 1;
        long k = 1;

        if (n-r < r) r = n - r;

        if (r!=0)
        {
            while (r > 0)
            {
                p = p * n;
                k = k * r;

                long m = gcd(p,k);

                p = p/m;
                k = k/m;

                n--;
                r--;
            }
        }
        else
        {
            p = 1;
        }

        return p;
    }

    static long newCombination(long n, long r, long p)
    {
        long[] C=new long[(int) (r+1)];

        C[0] = 1;

        for (int i = 1; i <= n; i++)
        {
            for (int j = (int) Math.min(i, r); j > 0; j--)
                C[j] = (C[j] + C[j-1])%p;
        }
        return C[(int) r];
    }

    static long power(long x, long y, long p)
    {
        long res = 1;

        x = x % p;

        while (y > 0) {

            if (y % 2 == 1)
                res = (res * x) % p;

            y = y >> 1;
            x = (x * x) % p;
        }

        return res;
    }

    static long modInverse(long n, long p)
    {
        return power(n, p - 2, p);
    }

    static long nCrModPFermat(long n, long r, long p)
    {

        if (r == 0)
            return 1;

        long[] fac = new long[(int) (n + 1)];
        fac[0] = 1;

        for (int i = 1; i <= n; i++)
            fac[i] = fac[i - 1] * i % p;

        return (fac[(int) n] * modInverse(fac[(int) r], p) % p * modInverse(fac[(int) (n - r)], p) % p) % p;
    }

    static long sumOfPrimes(int n)
    {

        boolean[] prime =new boolean[n + 1];


        Arrays.fill(prime, true);

        for (int p = 2; p * p <= n; p++) {


            if (prime[p]) {


                for (int i = p * 2; i <= n; i += p)
                    prime[i] = false;
            }
        }


        long sum = 0;
        for (long i = 2; i <= n; i++)
            if (prime[(int) i])
                sum += i;
        return sum;
    }

    static String findSubString(String str)
    {
        int n = str.length();

        int count = 0;

        boolean[] visited = new boolean[256];
        Arrays.fill(visited, false);

        for (int i = 0; i < n; i++) {
            if (visited[str.charAt(i)] == false) {
                visited[str.charAt(i)] = true;
                count++;
            }
        }

        int s = 0;
        int ind = -1;
        int mlen = Integer.MAX_VALUE;

        int cc = 0;
        int[] curr_count = new int[256];

        for (int j = 0; j < n; j++) {
            curr_count[str.charAt(j)]++;

            if (curr_count[str.charAt(j)] == 1)
                cc++;


            if (cc == count) {

                while (curr_count[str.charAt(s)] > 1) {
                    if (curr_count[str.charAt(s)] > 1)
                        curr_count[str.charAt(s)]--;
                    s++;
                }


                int len_window = j - s + 1;
                if (mlen > len_window) {
                    mlen = len_window;
                    ind = s;
                }
            }
        }

        return str.substring(ind, ind + mlen);
    }

    public static long sum_till(long n){
        return (n*(n+1))/2;
    }

    public static void main(String[] args) throws java.lang.Exception
    {
        try
        {
            Reader fr = new Reader();
            OutputStream out = new BufferedOutputStream(System.out);

            int testcases = fr.nextInt();

            while (testcases -- > 0)
            {
                int n = fr.nextInt();
                TreeSet<Integer> ts1 = new TreeSet<>();
                TreeSet<Integer> ts2 = new TreeSet<>();

                for (int i=0;i<n;i++)
                {
                    int ele = fr.nextInt();

                    if (ts1.contains(ele)) ts2.add(ele);
                    else ts1.add(ele);
                }

                long sum = 0;

                int k = 0;
                int ele1 = 0;

                for (int i : ts1)
                {
                    if (i!=k)
                    {
                        sum+=k;
                        break;
                    }
                    else
                    {
                        k++;
                        ele1 = i;
                    }
                }

                if (sum==0 && ts1.size()!=0)
                {
                    if (ts1.size() == 0) sum+=0;
                    else if (!ts1.contains(ele1)) sum+=ele1;
                    else sum+=(ele1+1);
                }

                long sum2 = 0;
                k = 0;
                ele1 = 0;

                for (int i : ts2)
                {
                    if (i!=k)
                    {
                        sum2+=k;
                        break;
                    }
                    else
                    {
                        k++;
                        ele1 = i;
                    }
                }

                if (sum2==0 && ts2.size()!=0)
                {
                    if (ts2.size() == 0) sum2+=0;
                    else if (!ts2.contains(ele1)) sum2+=ele1;
                    else sum2+=(ele1+1);
                }

//                out.write((ts1+"\n").getBytes());
//                out.write((ts2+"\n").getBytes());
//                out.write((sum+"\n").getBytes());
//                out.write((sum2+"\n").getBytes());

                out.write((sum+sum2+"\n").getBytes());
            }

            out.flush();
            out.close();
        }

        catch(Exception e){e.printStackTrace();}
        finally{}
    }
}


//(()) () (()((()()()())))