package Codeforces.Codeforces957;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D {
    static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();
        int jump = sc.nextInt();
        int swim = sc.nextInt();
        String s = sc.nextLine();

        if (jump > n) {
            yeah();
            return;
        }

        Queue<State> q = new LinkedList<>();
        q.offer(new State(0, swim));
        boolean[] vis = new boolean[n + 2];
        vis[0] = true;
        while (!q.isEmpty()) {
            State cur = q.poll();
            int currentX = cur.x;
            int availSwim = cur.availSwim;
            if (currentX == n + 1) {
                yeah();
                return;
            }
            if(currentX == 0 || s.charAt(currentX - 1) == 'L')
            {
                for (int i = 1; i <= jump; i++) {
                    int newX = currentX + i;
                    if (newX >= n + 1) {
                        yeah();
                        return;
                    }
                    if (!vis[newX] && s.charAt(newX - 1) != 'C') {
                        q.offer(new State(newX, availSwim));
                        vis[newX] = true;
                    }
                }
            }
            if (currentX <= n && currentX > 0 && s.charAt(currentX - 1) == 'W') {
                int newX = currentX + 1;
                int newAvailSwim = availSwim - 1;
                if (newAvailSwim >= 0 && newX == n + 1) {
                    yeah();
                    return;
                }
                if (newAvailSwim >= 0 && !vis[newX] && s.charAt(newX - 1) != 'C') {
                    q.offer(new State(newX, newAvailSwim));
                    vis[newX] = true;
                }
            }
        }
        nope();
    }

    static class State {
        int x, availSwim;

        public State(int x, int availSwim) {
            this.x = x;
            this.availSwim = availSwim;
        }
    }

    static void yeah() {
        System.out.println("YES");
    }

    static void nope() {
        System.out.println("NO");
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
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
