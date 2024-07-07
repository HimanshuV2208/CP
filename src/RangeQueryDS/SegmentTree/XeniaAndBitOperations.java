package RangeQueryDS.SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Compete.Codeforces problem
public class XeniaAndBitOperations {
    static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arrSize = (int) Math.pow(2, n);
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = sc.nextInt();
        }
        SGTreeOrXor seg = new SGTreeOrXor(arrSize);
        seg.build(0, 0, arrSize - 1, arr, (n % 2) == 0);
        for(int i = 0; i < m; i++){
            int updIdx = sc.nextInt();
            --updIdx;
            int updVal = sc.nextInt();
            seg.update(0, 0, arrSize -1, updIdx, updVal, (n % 2) == 0);
            System.out.println(seg.query());
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

class SGTreeOrXor {
    final int[] seg;

    SGTreeOrXor(int n) {
        seg = new int[4 * n + 1];
    }

    void build(int ind, int low, int high, int[] arr, boolean xor) {
        //Single element
        if (low == high) {
            seg[ind] = arr[low];
            return;
        }
        int mid = (low + high) >> 1;
        build(2 * ind + 1, low, mid, arr, !xor);
        build(2 * ind + 2, mid + 1, high, arr, !xor);
        if(xor) seg[ind] = seg[2 * ind + 1] ^ seg[2 * ind + 2];
        else seg[ind] = seg[2 * ind + 1] | seg[2 * ind + 2];
    }

    int query() {
        return seg[0];
    }

    void update(int ind, int low, int high, int updInd, int updVal, boolean xor) {
        if (low == high) {
            seg[ind] = updVal;
            return;
        }
        int mid = (low + high) >> 1;
        if (updInd <= mid) update(2 * ind + 1, low, mid, updInd, updVal, !xor);
        else update(2 * ind + 2, mid + 1, high, updInd, updVal, !xor);
        if(xor) seg[ind] = seg[2 * ind + 1] ^ seg[2 * ind + 2];
        else seg[ind] = seg[2 * ind + 1] | seg[2 * ind + 2];
    }

}
