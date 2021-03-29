import java.util.*;
import java.io.*;

public class Temp
{

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String word()
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

        int ni()
        {
            return Integer.parseInt(word());
        }

        long nl()
        {
            return Long.parseLong(word());
        }

        double nd()
        {
            return Double.parseDouble(word());
        }

        String line()
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

    static long gcd(long a, long b) { if (a == 0) return b;else return gcd(b % a, a); }

    static class Pair<X, Y> {
        public X first;
        public Y second;
        Pair(X first, Y second) { this.first = first;this.second = second; }
        public static <X, Y> Temp.Pair<X, Y> of(X a, Y b) { return new Temp.Pair<>(a, b); }
        public String toString() { return "(" + first + "," + second + ")"; }
    }
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        //Scanner fr = new Scanner(System.in);
        FastReader r = new FastReader();
        OutputStream out = new BufferedOutputStream(System.out);

       // int t = fr.nextInt();
        int t = 1;
        t=r.ni();
        here : while (t -- > 0){
            long n = r.nl();

            while (true){
                long temp = n;
                long sum = 0;
                while (temp!=0) {
                    sum+=temp%10;temp/=10;
                }
                if (gcd(sum,n)>1 ){
                    out.write((n + " ").getBytes());
                    out.write(("\n").getBytes());
                    continue here;
                }else n++;
            }
        }

        out.flush();
        out.close();
    }
}