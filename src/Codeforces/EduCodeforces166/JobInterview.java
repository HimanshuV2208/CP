package Codeforces.EduCodeforces166;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JobInterview {
    static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        int p = sc.nextInt();
        int t = sc.nextInt();
        int candidates = p + t + 1;
        int[] pSkills = new int[candidates];
        int[] tSkills = new int[candidates];
        for (int i = 0; i < candidates; i++) {
            pSkills[i] = sc.nextInt();
        }
        for (int i = 0; i < candidates; i++) {
            tSkills[i] = sc.nextInt();
        }
        for(int exclude = 0; exclude < candidates; exclude++){
            for (int i = 0; i < candidates; i++) {
            }
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
