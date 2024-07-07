package AtCoder.abc361;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class E {

    static int n;
    static List<Edge>[] g;
    static long[] dp;
    static long ans;
    static int cur;

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = (int) sc.nextLong();

        g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        dp = new long[n + 1];
        long tot = 0;
        for (int i = 1; i < n; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long z = sc.nextLong();
            tot += z;
            g[(int) x].add(new Edge((int) x, (int) y, z));
            g[(int) y].add(new Edge((int) y, (int) x, z));
        }

        ans = 0;
        dfs(1, 0);

        ans = 0;
        dp[cur] = 0;
        dfs(cur, 0);

        System.out.println(tot * 2 - ans);
    }

    static void dfs(int x, int y) {
        if (ans < dp[x]) {
            ans = dp[x];
            cur = x;
        }
        for (Edge edge : g[x]) {
            int v = edge.to;
            long len = edge.len;
            if (v == y) {
                continue;
            }
            dp[v] = dp[x] + len;
            dfs(v, x);
        }
    }

    static class FastReader {
        BufferedReader br;
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class Edge {
        int from, to;
        long len;

        Edge(int from, int to, long len) {
            this.from = from;
            this.to = to;
            this.len = len;
        }
    }
}

