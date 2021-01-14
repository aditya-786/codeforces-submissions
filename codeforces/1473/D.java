import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/*
        author @ Aditya Aggarwal

        LinkedIn : https://www.linkedin.com/in/aditya7861/

        ' The Dawn does not come twice to awaken the man '

        Never Give Up ... Failure is the biggest success
 */

public class Main {

    static Node[] segTree;
    static Node merge(Node node1, Node node2) {
        int start1 = node1.left, end1 = node1.right;
        int start2 = node1.sum + node2.left, end2 = node1.sum + node2.right;
        int sum = node1.sum + node2.sum;
        int maxStart = Math.min(start1, start2), maxEnd = Math.max(end1, end2);
        return new Node(maxStart, maxEnd, sum);
    }

    static void update(int index, int beg, int end, int pos, int ele) {
        if (pos < beg || pos > end) return;
        if (beg != end) {
            int mid = (beg + end)>>1;
            update(2 * index, beg, mid, pos, ele);
            update(2 * index + 1, mid + 1, end, pos, ele);
            segTree[index] = merge(segTree[2 * index], segTree[2 * index + 1]);
        } else {
            if (ele == 1) segTree[index] = new Node(0, ele, ele);
            else segTree[index] = new Node(ele, 0, ele);
            return;
        }
    }

    static Node query(int index, int s, int e, int qs, int qe) {
        if (qs <= e && s <= qe) {
            if (s == e || s >= qs && e <= qe) return segTree[index];

            int mid = (s + e) >> 1;
            Node left = query(2 * index, s, mid, qs, qe);
            Node right = query(2 * index + 1, mid + 1, e, qs, qe);
            return merge(left, right);
        } else {
            return new Node(0, 0, 0);
        }
    }


    static void run(){
        boolean tc = true;
        //AdityaFastIO r = new AdityaFastIO();
        FastReader r = new FastReader();

        try (OutputStream out = new BufferedOutputStream(System.out)) {
            int testcases = tc ? r.ni() : 1;
            // Hold Here Sparky------------------->>>
            // Solution Starts Here

            while (testcases -- > 0){
                int n = r.ni();
                int q = r.ni();
                segTree = new Node[4*n+1];
                for (int i=0;i<4*n+1;i++) segTree[i] = new Node(0,0,0);
                String s = r.word();
                for (int i=0;i<s.length();i++){
                    if (s.charAt(i)=='+') update(1, 0, n - 1, i, 1);
                    else update(1, 0, n - 1, i, -1);
                }
                int beg = 0, end = n-1, ind = 1;
                while (q-->0){
                    int start = r.ni();
                    start--;
                    int ending = r.ni();
                    ending--;
                    Node mn = query(ind, beg, end, 0, start - 1);
                    Node mx = query(ind, beg, end, ending + 1, end);
                    Node node = merge(mn,mx);
                    out.write((node.right - node.left + 1 + " ").getBytes());
                    out.write(("\n").getBytes());
                }
            }
            // Solution Ends Here
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Node{
        int left;
        int right;
        int sum;

        Node(int a, int b, int c) {
            left = a;
            right = b;
            sum = c;
        }
    }

    static class AdityaFastIO{
        final private int BUFFER_SIZE = 1<<16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;
        public BufferedReader br;
        public StringTokenizer st;

        public AdityaFastIO() {
            br = new BufferedReader(new InputStreamReader(System.in));
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public AdityaFastIO(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String word() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        public String line() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[100000001]; // line length
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
            long ret = 0;byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do { ret = ret * 10 + c - '0'; }
            while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;return ret;
        }

        public double nd() throws IOException {
            double ret = 0, div = 1;byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do { ret = ret * 10 + c - '0'; }
            while ((c = read()) >= '0' && c <= '9');
            if (c == '.') while ((c = read()) >= '0' && c <= '9') ret += (c - '0') / (div *= 10);
            if (neg) return -ret;return ret;
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
    public static void main(String[] args) throws java.lang.Exception {run();}

    /* variable initialization*/
    static long mod = 998244353;
    static long[] resArr;
    static long[] arr;
    static long modInv(long base, long e) {
        long result = 1;
        base %= mod;
        while (e>0) {
            if ((e & 1)>0) result = result * base % mod;
            base = base * base % mod;
            e >>= 1;
        }
        return result;
    }

    /* variable initialisation ends here */

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
            if (n % 2 == 1) result = result * x % MOD;
            n = n / 2;x = x * x % MOD;
        }
        return result;
    }

    static long powerStrings(int i1, int i2) {
        String sa = String.valueOf(i1);
        String sb = String.valueOf(i2);
        long a = 0, b = 0;
        for (int i = 0; i < sa.length(); i++) a = (a * 10 + (sa.charAt(i) - '0')) % MOD;
        for (int i = 0; i < sb.length(); i++) b = (b * 10 + (sb.charAt(i) - '0')) % (MOD - 1);
        return powerLL(a, b);
    }

    static long gcd(long a, long b) { if (a == 0) return b;else return gcd(b % a, a); }
    static long lcm(long a, long b) { return (a * b) / gcd(a, b); }

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
        if (s == list.size()) return -1; return s;
    }

    static void addEdge(ArrayList<ArrayList<Integer>> graph, int edge1, int edge2) {
        graph.get(edge1).add(edge2);graph.get(edge2).add(edge1);
    }

    public static class Pair {
        int first;int second;
        public Pair(int first, int second) { this.first = first;this.second = second; }
        public String toString() { return "(" + first + "," + second + ")"; }
    }

    static boolean isCollectionsSorted(List<Integer> list) {
        if (list.size() == 0 || list.size() == 1) return true;
        for (int i = 1; i < list.size(); i++) if (list.get(i) < list.get(i - 1)) return false;
        return true;
    }
}