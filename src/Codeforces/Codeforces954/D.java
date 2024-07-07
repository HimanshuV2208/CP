package Codeforces.Codeforces954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D {
    static final FastReader sc = new FastReader();
    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();
        String exp = sc.nextLine();
        if (n == 2) {
            System.out.println(Integer.parseInt(exp)); return;
        }
        if(exp.indexOf('0') == 0 || exp.indexOf('0') == n - 1){
            System.out.println(0); return;
        }
        if(n == 3) {
            if(exp.indexOf('0') == 1){
                int a = exp.charAt(0) - '0';
                int b = exp.charAt(2) - '0';
                System.out.println(Math.min(a + b, a * b));
            } else {
                int ab = Integer.parseInt(exp.substring(0, 2));
                int bc = Integer.parseInt(exp.substring(1, 3));
                int c = exp.charAt(2) - '0';
                int a = exp.charAt(0) - '0';
                int min = Math.min(Math.min(ab * c, ab + c), Math.min(a * bc, a + bc));
                System.out.println(min);
            }
            return;
        }
        int zero = 0;
        int[] a = new int[n];
        int k = 0;
        for(char c : exp.toCharArray()){
            if(c == '0') zero++;
            a[k++] = c - '0';
        }
        if(zero > 0) {
            if(n > 3) System.out.println(0);
            return;
        }
        long minResult = getMinResult(n, exp);
        System.out.println(minResult);
    }

    private static long getMinResult(int n, String exp) {
        long minResult = Long.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            List<Integer> numbers = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String val;
                if (j == i) {
                    val = "" + exp.charAt(j) + exp.charAt(j + 1);
                    j++;
                } else {
                    val = "" + exp.charAt(j);
                }
                numbers.add(Integer.parseInt(val));
            }
            long currentSum = numbers.getFirst();
            if (currentSum == 1) {
                currentSum = 0;
            }
            for (int k = 1; k < numbers.size(); k++) {
                if (numbers.get(k) != 1) {
                    currentSum += numbers.get(k);
                }
            }
            minResult = Math.min(minResult, currentSum);
        }
        return minResult;
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
