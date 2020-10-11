import java.io.*;
import java.math.BigInteger;
import java.util.*;

/*
        author : Aditya Aggarwal

        ' The Dawn does not come twice to awaken the man '  ---->>> By my brother ( My Motivation )

        Believe In yourself, Everything is possible.

        Never Give Up
 */

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
        private final DataInputStream din;
        private final byte[] buffer;
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

    static void addEdge(ArrayList<ArrayList<Integer>>graph, int edge1, int edge2)
    {
        graph.get(edge1).add(edge2);
        graph.get(edge2).add(edge1);
    }

    static class Pair<X,Y>
    {
        public final X first;
        public final Y second;

        Pair(X first, Y second)
        {
            this.first = first;
            this.second = second;
        }

        public static <X,Y> Pair <X,Y> of (X a, Y b)
        {
            return new Pair<>(a,b);
        }

        public String toString()
        {
            return "("+first+","+second+")";
        }
    }

    static long permutations(int n , long k)
    {
        long[][] dp = new long[n+1][(int) (k+1)];

        for (int j=0;j<=k;j++) dp[0][j] = 0;

        for (int i=1;i<=n;i++) dp[i][0] = 1;

        for (int i=1;i<=n;i++)
        {
            for (int j=1;j<=k;j++)
            {
                for (int m=0;m<i && m<=j; m++)
                {
                    dp[i][j]+=dp[i-1][j-m];
                }
            }
        }

        return dp[n][(int) k]%2;
    }

    static long returningAns(HashSet<Long> hslist2, HashSet<Long> hs1, HashSet<Long> hs2, List<Long> list2, int size)
    {
        long ans = 0;

        for (int i=0;i<=size;i++)
        {
            if (!hslist2.contains(i)) {
                HashSet<Long> hs = new HashSet<>();

                for (int j = 0; j < list2.size(); j++) {
                    if (!(i <= list2.get(j))) hs.add(i - list2.get(j));
                    else hs.add(list2.get(j) - i);
                }

                long res = 0;

                for (long j : hs1) if (hs1.contains(j) || hs2.contains(j)) res += 1;

                ans = Math.max(ans,res);
            }


        }

        return ans;
    }

    static void updateHashSet1(HashSet<Long> hs, int n, List<Long> list)
    {
        for (int i=0;i<n;i++)
        {
            for (int j=i+1;j<n;j++)
            {
                if (list.get(i)<list.get(j)) hs.add(list.get(j)-list.get(i));
                else hs.add(list.get(i)-list.get(j));
            }
        }
    }

    static void updateHashSet2(HashSet<Long> hs, int m, List<Long> list)
    {
        for (int i=0;i<m;i++)
        {
            for (int j=i+1;j<m;j++)
            {
                if (list.get(i)<list.get(j)) hs.add(list.get(j)-list.get(i));
                else hs.add(list.get(i)-list.get(j));
            }
        }
    }

    public static void main(String[] args) throws java.lang.Exception
    {
        try
        {
            //FastReader fr = new FastReader();
            Reader fr = new Reader();

            try (OutputStream out = new BufferedOutputStream(System.out))
            {
                int testcases = fr.nextInt();

                while (testcases -- > 0)
                {
                    int n = fr.nextInt();

                    boolean ff = false;

                    for (int i=0;i<145;i++)
                    {
                        for (int j=0;j<200;j++)
                        {
                            for (int k=0;k<350;k++)
                            {
                                long ans = 7*i+5*j+3*k;

                                if (ans == n)
                                {
                                    out.write((k+" "+j+" "+i+"\n").getBytes());
                                    ff = true;
                                    break;
                                }

                                if (7*i > n)
                                    break;
                            }

                            if (ff) break;
                        }

                        if (ff) break;
                    }

                    if (!ff) out.write((-1+"\n").getBytes());

                    out.flush();
                }
            }
        }

        catch(Exception e){}
        finally{}
    }
}


//(()) () (()((()()()())))