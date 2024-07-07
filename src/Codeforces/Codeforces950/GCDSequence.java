package Codeforces.Codeforces950;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GCDSequence {
    static final FastReader sc = new FastReader();

    static boolean valid(ArrayList<Integer> a) {
        int n = a.size();
        ArrayList<Integer> g = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            g.add(gcdOfNumbers(a.get(i), a.get(i + 1)));
        }
        for (int i = 1; i < n - 1; i++) {
            if (g.get(i) < g.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    static int gcdOfNumbers(int a, int b) {
        if (b == 0) return a;
        return gcdOfNumbers(b, a % b);
    }

    static void solve() {
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        ArrayList<Integer> gcdList = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            gcdList.add(gcdOfNumbers(a.get(i), a.get(i + 1)));
        }
        int problemAtIndex = -1;
        for (int i = 1; i < n - 1; i++) {
            if (gcdList.get(i) < gcdList.get(i - 1)) {
                problemAtIndex = i;
                break;
            }
        }
        if (problemAtIndex == -1) {
            System.out.println("YES");
            return;
        }
        for (int j = problemAtIndex - 1; j <= problemAtIndex + 1; j++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (i != j) {
                    temp.add(a.get(i));
                }
            }
            if (valid(temp)) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
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
