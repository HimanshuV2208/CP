package Practice.Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem2A {
    static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        int n, ans = 0;
        n = sc.nextInt();
        String[] s = new String[n];
        int[] ar = new int[n];
        HashMap<String, Integer> m = new HashMap<>();
        HashMap<String, Integer> p = new HashMap<>();
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
            ar[i] = sc.nextInt();
            m.put(s[i], m.getOrDefault(s[i], 0) + ar[i]);
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, m.get(s[i]));
        }
        for (int i = 0; i < n; i++) {
            p.put(s[i], p.getOrDefault(s[i], 0) + ar[i]);
            if (m.get(s[i]) == ans && p.get(s[i]) >= ans) {
                System.out.println(s[i]);
                return;
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
                } catch (IOException ignored) {
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}


