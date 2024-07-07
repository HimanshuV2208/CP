package Codeforces.Codeforces950;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ChoosingCubes {
    static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();
        int f = sc.nextInt();
        f--;
        int k = sc.nextInt();
        k--;
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        int favouriteDiceVal = a.get(f);
        a.sort(Collections.reverseOrder());
        int l = a.indexOf(favouriteDiceVal);
        int r = a.lastIndexOf(favouriteDiceVal);
        if(l == r) {
            if (k >= l) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            return;
        }
        if(k < l) System.out.println("NO");
        else if(k >= r) System.out.println("YES");
        else System.out.println("MAYBE");
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
