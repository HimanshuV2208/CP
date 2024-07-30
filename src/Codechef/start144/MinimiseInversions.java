package Codechef.start144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MinimiseInversions {
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
        String x = sc.nextLine();
        char[] s = x.toCharArray();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s[i] - '0';
        }
        long initialInversions = inversionCount(a, n);
        if(k == 0) {
            System.out.println(initialInversions); return;
        }
        long[] onesToLeft = new long[n];
        long[] zerosToRight = new long[n];
        long countOnes = 0;
        for (int i = 0; i < n; i++) {
            onesToLeft[i] = countOnes;
            if (a[i] == 1) {
                countOnes++;
            }
        }
        long countZeros = 0;
        for (int i = n - 1; i >= 0; i--) {
            zerosToRight[i] = countZeros;
            if (a[i] == 0) {
                countZeros++;
            }
        }
        PriorityQueue<Long> vals = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            if(a[i] == 0) vals.offer(onesToLeft[i]);
            else vals.offer(zerosToRight[i]);
        }
        while(k --> 0){
            initialInversions -= vals.poll();
            if(initialInversions <= 0) break;
        }
        long ans = 0;
        System.out.println(initialInversions);
    }

    static void _printArr(long[] arr) {
        StringBuilder sb = new StringBuilder();
        for (long x : arr) sb.append(x).append(" ");
        System.out.println(sb);
    }

    static long inversionCount(int[] arr, int n) {
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    static long countOnes(int[] arr, int start, int end) {
        long count = 0;
        for (int i = start; i < end; i++) {
            if (arr[i] == 1) {
                count++;
            }
        }
        return count;
    }

    static long countZeros(int[] arr, int start, int end) {
        long count = 0;
        for (int i = start; i < end; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }
        return count;
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
