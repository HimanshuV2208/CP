package AtCoder.arc179.A;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        List<Integer> negatives = new ArrayList<>();
        List<Integer> nonNegatives = new ArrayList<>();

        for (int num : a) {
            if (num < 0) {
                negatives.add(num);
            } else {
                nonNegatives.add(num);
            }
        }
        if (negatives.isEmpty()) {
            int sum = 0;
            for (Integer nonNegative : nonNegatives) {
                sum += nonNegative;
            }
            if (sum < k) {
                System.out.println("No");
                return;
            }
        }
        List<Integer> goodSequence = new ArrayList<>();
        goodSequence.addAll(negatives);
        goodSequence.addAll(nonNegatives);
        System.out.println("Yes");
        for (int i = 0; i < goodSequence.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(goodSequence.get(i));
        }
        System.out.println();

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

