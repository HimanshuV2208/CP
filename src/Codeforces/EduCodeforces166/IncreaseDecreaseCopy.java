package Codeforces.EduCodeforces166;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IncreaseDecreaseCopy {
    static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n+1];
        int maxi = Integer.MIN_VALUE, mini = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            maxi = Math.max(a[i], maxi);
            mini = Math.min(a[i], mini);
        }
        for (int i = 0; i < n+1; i++) {
            b[i] = sc.nextInt();
            if(i!=n){
                maxi = Math.max(b[i], maxi);
                mini = Math.min(b[i], mini);
            }
        }
        int last = b[n];
        long ans = 0;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            int max = Math.max(a[i], b[i]);
            int min = Math.min(a[i], b[i]);
            if(min <= last && last <= max) found = true;
            ans += Math.abs((long) a[i] - (long) b[i]);
        }
        if(found) {
            System.out.println(ans+1);
            return;
        }
        long steps = Math.min(Math.abs((long) maxi - (long) last), Math.abs((long) mini-(long) last));
        System.out.println(ans + steps + 1);
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
