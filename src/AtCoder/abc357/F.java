package AtCoder.abc357;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class F {
    static final int MOD = 998244353;
    static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        List<List<Integer>> queries = new ArrayList<>();
        for(int i = 0; i < q; i++){
            List<Integer> query = new ArrayList<>();
            int type = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            l--; r--;
            query.add(type);
            query.add(l);
            query.add(r);
            if(type != 3) query.add(sc.nextInt());
            queries.add(query);
        }
        for(List<Integer> query : queries){
            int type = query.getFirst();
            int l = query.get(1);
            int r = query.get(2);
            if(type == 1){
                int x = query.get(3);
                for(int i = l; i <= r; i++){
                    a[i]+=x;
                }
            } else if (type == 2){
                int x = query.get(3);
                for(int i = l; i <= r; i++){
                    b[i]+=x;
                }
            } else if (type == 3){
                long ans = 0;
                for(int i = l; i <= r; i++){
                    ans = ans % MOD + ((long) (a[i] % MOD) * (b[i] % MOD)) % MOD;
                }
                System.out.println(ans % MOD);
            }
        }
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
