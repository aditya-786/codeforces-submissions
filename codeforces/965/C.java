import java.io.*;
import java.util.*;
/*
        author : Aditya Aggarwal

        LinkedIn : https://www.linkedin.com/in/aditya7861/

        ' The Dawn does not come twice to awaken the man '  ---->>>  ( My Motivation )

        Believe In yourself, Everything is possible.

        Never Give Up ... Failure is the biggest success
 */

public class Main {
    static AdityaFastIO r = new AdityaFastIO();
    //static FastReader r = new FastReader();
    static boolean tc = false;
    static void solve() throws IOException{

        // Solution Starts Here

        try(OutputStream out = new BufferedOutputStream(System.out)){
            long n = r.nl();
            long k = r.nl();
            long m = r.nl();
            long d = r.nl();

            long res = 0;

            long i = 1;
            while (i <= d) {
                long temp = n / ((long) k * (i - 1) + 1);
                if (temp >= m) res = Math.max(res, m * i);
                else res = Math.max(res, temp * i);
                if (temp == 0) break;
                i++;
            }
            out.write((res + "").getBytes());
        }

        // Solution Ends Here
    }

    static class AdityaFastIO{
        final private int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;
        BufferedReader br;
        StringTokenizer st;

        public AdityaFastIO() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public AdityaFastIO(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        String word() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        String line() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int ni() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do { ret = ret * 10 + c - '0'; }
            while ((c = read()) >= '0' && c <= '9');

            if (neg) return -ret;
            return ret;
        }

        public long nl() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do { ret = ret * 10 + c - '0'; }
            while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        public double nd() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();

            do { ret = ret * 10 + c - '0'; }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') while ((c = read()) >= '0' && c <= '9') ret += (c - '0') / (div *= 10);

            if (neg) return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null) return;
            din.close();
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String word() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        String line() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
        int ni() { return Integer.parseInt(word()); }
        long nl() { return Long.parseLong(word()); }
        double nd() { return Double.parseDouble(word()); }
    }

    static int MOD = (int) (1e9 + 7);

    static long powerLL(long x, long n) {
        long result = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                result = result * x % MOD;
            }
            n = n / 2;
            x = x * x % MOD;
        }
        return result;
    }

    static long powerStrings(String sa, String sb) {
        long a = 0, b = 0;
        for (int i = 0; i < sa.length(); i++) a = (a * 10 + (sa.charAt(i) - '0')) % MOD;
        for (int i = 0; i < sb.length(); i++) b = (b * 10 + (sb.charAt(i) - '0')) % (MOD - 1);
        return powerLL(a, b);
    }

    static long gcd(long a, long b) {
        if (a == 0) return b;
        else return gcd(b % a, a);
    }

    static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    static long lower_bound(List<Long> list, long k) {
        int s = 0;
        int e = list.size();

        while (s != e) {
            int mid = (s + e) >> 1;
            if (list.get(mid) < k) s = mid + 1;
            else e = mid;
        }
        if (s == list.size()) return -1;
        return s;
    }

    static int upper_bound(List<Long> list, long k) {
        int s = 0;
        int e = list.size();

        while (s != e) {
            int mid = (s + e) >> 1;
            if (list.get(mid) <= k) s = mid + 1;
            else e = mid;
        }
        if (s == list.size()) return -1;
        return s;
    }

    static void addEdge(ArrayList<ArrayList<Integer>> graph, int edge1, int edge2) {
        graph.get(edge1).add(edge2);graph.get(edge2).add(edge1);
    }

    static class Pair<X, Y> {
        public X first;
        public Y second;

        Pair(X first, Y second) { this.first = first;this.second = second; }

        public static <X, Y> Pair<X, Y> of(X a, Y b) { return new Pair<>(a, b); }

        public String toString() { return "(" + first + "," + second + ")"; }
    }

    static boolean isCollectionsSorted(List<Integer> list) {
        if (list.size() == 0 || list.size() == 1) return true;
        for (int i = 1; i < list.size(); i++) if (list.get(i) > list.get(i - 1)) return false;
        return true;
    }

    public static void main(String[] args) throws java.lang.Exception {
        try {
            AdityaFastIO r = new AdityaFastIO();
            FastReader fr = new FastReader();
            try (OutputStream out = new BufferedOutputStream(System.out)) {
                int testcases = tc ? r.ni() : 1;
                while (testcases-- > 0) solve();
            }
        } catch (Exception e) {
        } finally {
        }
    }
}