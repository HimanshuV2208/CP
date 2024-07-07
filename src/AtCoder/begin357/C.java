package AtCoder.begin357;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
    static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();
        String[] carpet = createCarpet(n);
        for (String line : carpet) {
            System.out.println(line);
        }
    }

    static String[] createCarpet(int N) {
        if (N == 0) {
            return new String[]{"#"};
        }
        String[] smallerCarpet = createCarpet(N - 1);
        int smallerSize = smallerCarpet.length;
        int newSize = 3 * smallerSize;
        String[] newCarpet = new String[newSize];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int r = 0; r < smallerSize; r++) {
                    if (newCarpet[i * smallerSize + r] == null) {
                        newCarpet[i * smallerSize + r] = "";
                    }
                    if (i == 1 && j == 1) {
                        newCarpet[i * smallerSize + r] += ".".repeat(smallerSize);
                    } else {
                        newCarpet[i * smallerSize + r] += smallerCarpet[r];
                    }
                }
            }
        }

        return newCarpet;
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
