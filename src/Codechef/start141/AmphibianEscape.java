package Codechef.start141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AmphibianEscape {
    static final FastReader sc = new FastReader();
    static final int P_INF = Integer.MAX_VALUE;
    static final int N_INF = Integer.MIN_VALUE;
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int h = sc.nextInt();
        long steps = 0;
        int slip = 1;
        for(int jump = 1; jump <= n; jump++) {
            if (jump >= h) {
                steps += n;
            } else {
                while (slip <= ((long)jump * k - h) / (k - 1)) {
                    slip++;
                }
                steps = steps + (slip - 1);
            }
        }
        System.out.println(steps);
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
