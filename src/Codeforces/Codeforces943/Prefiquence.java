package Codeforces.Codeforces943;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prefiquence {
    static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
           solve2();
        }
    }

    static void solve() {
        int n = sc.nextInt(); int m = sc.nextInt();
        String a = sc.nextLine(); String b = sc.nextLine();
        for (int i = n; i > 0; i--) {
            if(isSubsequence(a.substring(0, i), b)){
                System.out.println(i); return;
            }
        }
    }
    static void solve2() {
        int n = sc.nextInt(); int m = sc.nextInt();
        String a = sc.nextLine(); String b = sc.nextLine();
        int k = 0, prev = 0;
        for (int i = 0; i < n; i++) {
            if(b.substring(prev).indexOf(a.charAt(i))==-1){
                System.out.println(k);
                return;
            }else {
                prev = i+1;
                k++;
            }
        }
        System.out.println(k);
    }

    static boolean isSubsequence(String s, String t) {
        // s is a subsequence of t
        if (s.length() == 0) return true;
        int indexS = 0, indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) return true;
            }
            indexT++;
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
