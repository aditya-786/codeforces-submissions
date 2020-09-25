import java.io.*;
import java.util.*;

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

    static void addEdge(ArrayList<ArrayList<Integer>>graph, int edge1, int edge2)
    {
        graph.get(edge1).add(edge2);
        graph.get(edge2).add(edge1);
    }

    static int BFS(ArrayList<ArrayList<Integer>>graph, int vertices, int source)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        boolean[] visited = new boolean[vertices+1];
        visited[source] = true;

        //int count = 0;

        int k = 0;
        int count = 1;
        int c = 0;

        while (!queue.isEmpty())
        {
            int vertex = queue.poll();

            if (vertex == 1) return count;



            for (int i : graph.get(vertex))
            {

                if (i == 1) return count;

                if (!visited[i])
                {
                    count++;
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        return count;
    }

    static int findmaxelements(List<Long>list1, List<Long>list2, int n)
    {
        n = list1.size();
        // Index counter for arr1
        int cnt1 = 0;

        // Index counter for arr1
        int cnt2 = 0;

        // To store the maximum elements
        int maxelements = 0;

        while(cnt1 < n && cnt2 < n)
        {

            // If element is greater,
            // update maxelements and counters
            // for both the arrays
            if(list1.get(cnt1) >= list2.get(cnt2))
            {
                maxelements++;
                cnt1++;
                cnt2++;
            }
            else
            {
                cnt1++;
            }
        }

        // Print the maximum elements
        //System.out.println(maxelements);

        return maxelements;
    }

    public static void main(String[] args) throws java.lang.Exception
    {
        try
        {
            //FastReader fr = new FastReader();
            Reader fr = new Reader();

            try(OutputStream out = new BufferedOutputStream(System.out))
            {
                int queries = fr.nextInt();

                while (queries -- > 0)
                {
                    int n = fr.nextInt();
                    List<Long> list = new ArrayList<>();
                    for (int i=0;i<n;i++) list.add(fr.nextLong());

                    /*
                            0 0 0 1
                            0 1 0 0
                            0 0 1 1
                            0 1 1 1
                            1 0 1 0

                            1
                            1
                            1

                           6 -> 1 1 0  // 3  -> 1
                           5 -> 0 1 0  // 2  -> 1
                           2 -> 1 0 1  // 3  -> 2
                           3 -> 0 1 1  // 2  -> 2

                     */

                    HashMap<Long,Long> setBits = new HashMap<>();
                    for (int i=0;i<n;i++)
                    {
                        String s = Long.toBinaryString(list.get(i));

                        long count = s.length();

                        for (int j=0;j<s.length();j++)
                        {
                            if (s.charAt(j) == '1')
                            {
                                if (setBits.containsKey(count)) setBits.put(count,setBits.get(count)+1);
                                else setBits.put(count,1L);
                                break;
                            }
                            else
                            {
                                count--;
                            }
                        }
                    }

                    long count = 0;

                    for (Map.Entry<Long,Long>entry : setBits.entrySet())
                    {
                        long freq = entry.getValue();

                       // out.write((freq+" ").getBytes());

                        if (freq>1) count+=((freq)*(freq-1))/2;
                    }

                    if (count == 0) out.write((count+"\n").getBytes());
                    else
                    {
                      //  long ans = ((count)*(count-1))/2;

                        out.write((count+"\n").getBytes());
                    }
                }

                out.flush();
            }
        }

        catch(Exception e){}
        finally{}
    }
}


//(()) () (()((()()()())))