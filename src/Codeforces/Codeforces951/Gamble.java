package Codeforces.Codeforces951;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Gamble {
    static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();
        List<BigInteger> v = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            v.add(new BigInteger(sc.next()));
        }

        BigInteger x = BigInteger.ONE;

        for (BigInteger val : v) {
            BigInteger y = x.gcd(val);
            y = val.divide(y);
            x = x.multiply(y);
        }

        BigInteger sum = BigInteger.ZERO;
        List<BigInteger> ans = new ArrayList<>();

        for (BigInteger val : v) {
            BigInteger quotient = x.divide(val);
            sum = sum.add(quotient);
            ans.add(quotient);
        }

        if (sum.compareTo(x) < 0) {
            for (BigInteger val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }
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
