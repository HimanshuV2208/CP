package Codeforces.Codeforces954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E {
    static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Long> elements = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            elements.add(sc.nextLong());
        }
        Map<Long, Set<Long>> setMap = new HashMap<>();
        for (long elt : elements) {
            long rem = elt % k;
            setMap.putIfAbsent(rem, new HashSet<>());
            if (!setMap.get(rem).contains(elt)) {
                setMap.get(rem).add(elt);
            } else {
                setMap.get(rem).remove(elt);
            }
        }
        int odd = 0;
        long oddRem = -1, ans = 0;
        for (Map.Entry<Long, Set<Long>> entry : setMap.entrySet()) {
            if ((entry.getValue().size() & 1) != 0) {
                odd++;
                oddRem = entry.getKey();
            }
        }
        if (odd > 1) {
            System.out.println(-1);
            return;
        }
        for (Map.Entry<Long, Set<Long>> entry : setMap.entrySet()) {
            if (entry.getKey() == oddRem) continue;
            List<Long> values = new ArrayList<>(entry.getValue());
            Collections.sort(values);
            for (int i = 0; i < values.size(); i += 2) {
                if (i + 1 < values.size()) {
                    ans += (values.get(i + 1) - values.get(i)) / k;
                }
            }
        }
        if (odd == 1) {
            List<Long> oddVals = new ArrayList<>(setMap.get(oddRem));
            Collections.sort(oddVals);
            int m = oddVals.size();
            if (m == 1) {
                System.out.println(ans);
                return;
            }
            long[] pfx = new long[m];
            long[] sfx = new long[m];
            pfx[1] = oddVals.get(1) - oddVals.get(0);
            for (int i = 3; i < m; i += 2) {
                pfx[i] = oddVals.get(i) - oddVals.get(i - 1) + pfx[i - 2];
            }
            sfx[m - 2] = oddVals.get(m - 1) - oddVals.get(m - 2);
            for (int i = m - 4; i >= 0; i -= 2) {
                sfx[i] = oddVals.get(i + 1) - oddVals.get(i) + sfx[i + 2];
            }
            long extra = Long.MAX_VALUE;
            for (int i = 0; i < m; i += 2) {
                long additionalCost = 0;
                if (i > 0) additionalCost += pfx[i - 1];
                if (i + 1 < m) additionalCost += sfx[i + 1];
                extra = Math.min(extra, additionalCost);
            }
            ans += extra / k;
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
