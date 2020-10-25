import java.util.*;
import java.io.*;

public class Main
{
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
    
    static void fillArray1(int[] cols, int [][] arr1, int n, int m)
    {
        for (int j=0;j<n;j++)
                    {
                        for (int i=0;i<m;i++) cols[arr1[j][i]] = i;
                    }
    }
    static void fillArray2(int[] cols, int [][] arr1, int n, int m)
    {
        for (int j=0;j<m;j++)
                    {
                        for (int i=0;i<n;i++) cols[arr1[j][i]] = i;
                    }
    }
    
    public static void main(String[] args) throws java.lang.Exception
    {
        try
        {
            Reader fr = new Reader();
            
            int testcases = fr.nextInt();

                while (testcases -- > 0)
                {
                    int n = fr.nextInt();
                    int m = fr.nextInt();

                    int[][] arr1 = new int[n][m];
                    int[][] arr2 = new int[m][n];

                    for (int i=0;i<n;i++) for (int j=0;j<m;j++) arr1[i][j] = fr.nextInt();
                    for (int i=0;i<m;i++) for (int j=0;j<n;j++) arr2[i][j] = fr.nextInt();

                    int[] rows = new  int[n*m+2];
                    int[] cols = new int[n*m+2];

                    fillArray1(cols,arr1,n,m);
                    fillArray2(rows,arr2,n,m);

                    int[][] mat = new int[n+2][m+2];

                    for (int i=0;i<(n*m+1);i++)mat[rows[i]][cols[i]] = i;

                    for (int i=0;i<n;i++)
                    {
                        for (int j=0;j<m;j++)
                        {
                            System.out.print(mat[i][j]+" ");
                        }

                        System.out.println();
                    }
                }
            
        }
        
        catch(Exception e){}
        finally{}
    }
}