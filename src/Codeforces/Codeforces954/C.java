package Codeforces.Codeforces954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C {
    static final FastReader sc = new FastReader();
    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.nextLine();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            int temp = sc.nextInt() - 1;
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        String c = sc.nextLine();
        char[] chars = c.toCharArray();
        Arrays.sort(chars);
        int l = 0, r = m - 1;
        StringBuilder ans = new StringBuilder(s);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int index = entry.getKey();
            int freq = entry.getValue();
            if(freq == 1) ans.setCharAt(index, chars[l++]);
            else {
                for(int i = 0; i < freq - 1; i++){
                    r--;
                }
                ans.setCharAt(index, chars[l++]);
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
