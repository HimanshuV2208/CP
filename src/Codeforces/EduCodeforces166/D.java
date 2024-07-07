package Codeforces.EduCodeforces166;

import java.io.*;
import java.util.*;

public class D {
    static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        String s = sc.nextLine();
        int n = s.length();
        long[] para = new long[n + 2];
        List<List<Integer>> index = new ArrayList<>(n + 5);

        for (int i = 0; i < n + 5; i++) {
            index.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            long x = 1;
            if (s.charAt(i - 1) == ')') {
                x = -1;
            }
            para[i] = x + para[i - 1];
            index.get((int) para[i]).add(i);
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(n + 1);

        long ans = 0;
        int k = n;
        for (int i = n; i >= 0; i--) {
            while (k > 2 * i) {
                treeSet.addAll(index.get(k));
                k--;
            }
            List<Integer> v = index.get(i);
            int size = v.size();
            if (size == 0) continue;
            for (int j = 0; j < size; j++) {
                int x = v.get(j);
                int till = treeSet.higher(x);
                int lo = j, hi = size;
                while (hi - lo > 1) {
                    int mid = lo + (hi - lo) / 2;
                    if (v.get(mid) < till) {
                        lo = mid;
                    } else {
                        hi = mid;
                    }
                }
                ans += (lo - j);
            }
        }

        System.out.println(ans);
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
