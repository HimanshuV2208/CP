package Codeforces.Codeforces946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces {
    static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve2();
        }
    }

    static void solve2(){
        int n = sc.nextInt();
        String s = sc.nextLine();

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

    static class Pair {
        final int first;
        final int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int hashCode() {
            return 31 * first + second;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Codeforces.Pair pair = (Codeforces.Pair) obj;
            return first == pair.first && second == pair.second;
        }
    }

    static class Triple {
        final int first;
        final int second;
        final int third;
        Triple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        @Override
        public int hashCode() {
            return 31 * (31 * first + second) + third;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Codeforces.Triple triple = (Codeforces.Triple) obj;
            return first == triple.first && second == triple.second && third == triple.third;
        }
    }

}
