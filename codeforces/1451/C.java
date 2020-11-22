import java.io.*;
import java.text.*;
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

    static int MOD = (int) (1e9 + 7);

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

    static void print(Object o) throws IOException {
        OutputStream out = new BufferedOutputStream(System.out);

        out.write((o+" ").getBytes());

        out.flush();
    }

    static void println(Object o) throws IOException {
        OutputStream out = new BufferedOutputStream(System.out);

        out.write((o+"\n").getBytes());

        out.flush();
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

    public static void main(String[] args) throws java.lang.Exception
    {
        try
        {
            FastReader fr = new FastReader();
            //Reader fr = new Reader();

            try (OutputStream out = new BufferedOutputStream(System.out))
            {
                int testcases = fr.nextInt();

                while (testcases -- > 0)
                {
                    int n = fr.nextInt();
                    int k = fr.nextInt();

                    String a = fr.nextLine();
                    String b = fr.nextLine();

                    int[] c1 = new int[26];
                    int[] c2 = new int[26];

                    for (int i=0;i<a.length();i++) c1[a.charAt(i)-'a']++; // counting frequency of each character in String a
                    for (int i=0;i<b.length();i++) c2[b.charAt(i)-'a']++; // counting frequency of each character in String b

                    boolean ff = true;

                    for (int i=0;i<25;i++) // running loop till 25 only, because we are shifting the remaining chars to next
                    {
                        if (c1[i] < c2[i]) // suppose String a has 6 times 'a' char and String b has 8 times 'a' char present
                        {                  // as we can only increase the present char, not decrease it, so if the count is less, just break, and print "NO"
                            ff = false;
                            break;
                        }
                        else
                        {
                            int diff = c1[i] - c2[i];

                            if (diff%k!=0) // to convert it, we can only take length of size k, if its remaining length is not proper divisible by k,
                            {              // then it will never be possible, just break the loop and print "NO"
                                ff = false;
                                break;
                            }
                            else c1[i+1]+=diff; // if it is divisible by k, just shift the next remaining chars to next
                                                // just because of this, I am running my loop 25 times, because I am shifting to next
                        }
                    }

                    if (ff) println("YES");
                    else println("NO");
                }
            }
        }
        catch(Exception e){}
        finally{}
    }
}


//(()) () (()((()()()())))
