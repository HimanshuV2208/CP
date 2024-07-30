package Codeforces.Codeforces961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class B2 {
    static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();
        long m = sc.nextLong();
        TreeMap<Integer, Long> itemCounts = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();
            long count = sc.nextLong();
            itemCounts.put(type, itemCounts.getOrDefault(type, 0L) + count);
        }

        long low = 0, high = m, ans = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canAchieveSum(itemCounts, n, m, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(ans);
    }

    static boolean canAchieveSum(TreeMap<Integer, Long> itemCounts, int n, long m, long target) {
        long windowSum = 0;
        long remainingM = m;
        Map.Entry<Integer, Long> left = itemCounts.firstEntry();

        for (Map.Entry<Integer, Long> right : itemCounts.entrySet()) {
            windowSum += right.getKey() * right.getValue();

            while (left != null && right.getKey() - left.getKey() > 1) {
                windowSum -= left.getKey() * left.getValue();
                left = itemCounts.higherEntry(left.getKey());
            }

            while (left != null && windowSum > target) {
                long excess = windowSum - target;
                long reduceCount = (excess + left.getKey() - 1) / left.getKey();
                if (reduceCount >= left.getValue()) {
                    windowSum -= left.getKey() * left.getValue();
                    left = itemCounts.higherEntry(left.getKey());
                } else {
                    windowSum -= left.getKey() * reduceCount;
                    itemCounts.put(left.getKey(), left.getValue() - reduceCount);
                }
            }

            if (windowSum <= target && remainingM >= windowSum) {
                return true;
            }
        }

        return false;
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
