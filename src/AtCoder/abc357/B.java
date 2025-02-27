package AtCoder.abc357;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
    static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        String s = sc.next();
        int l = 0, u = 0;
        for(char c : s.toCharArray()){
            if(Character.isUpperCase(c)) u++;
            else if(Character.isLowerCase(c)) l++;
        }
        if(u > l) System.out.println(s.toUpperCase());
        else System.out.println(s.toLowerCase());
    }

    static class FastReader {
        final BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) str = st.nextToken("\n");
                else str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
