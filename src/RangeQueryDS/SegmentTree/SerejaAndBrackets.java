package RangeQueryDS.SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Compete.Codeforces problem
public class SerejaAndBrackets {
    static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        String s = sc.next();
        int m = sc.nextInt();
        SGTreeBrackets seg = new SGTreeBrackets(s.length());
        seg.build(0, 0, s.length() - 1, s);
        while (m-- > 0) {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            int balanced = seg.query(0, 0, s.length() - 1, l, r).full;
            System.out.println(balanced * 2);
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

class SGTreeBrackets {
    final Node[] seg;

    SGTreeBrackets(int n) {
        seg = new Node[4 * n + 1];
    }

    Node merge(Node left, Node right) {
        int combined = Math.min(left.open, right.close);
        int full = left.full + right.full + combined;
        int open = left.open + right.open - combined;
        int close = left.close + right.close - combined;
        return new Node(open, close, full);
    }

    void build(int ind, int low, int high, String s) {
        //Single element
        if (low == high) {
            int open = 0, close = 0;
            if (s.charAt(low) == '(') open++;
            else close++;
            Node node = new Node(open, close, 0);
            seg[ind] = node;
            return;
        }
        int mid = (low + high) >> 1;
        build(2 * ind + 1, low, mid, s);
        build(2 * ind + 2, mid + 1, high, s);
        Node left = seg[2 * ind + 1];
        Node right = seg[2 * ind + 2];
        seg[ind] = merge(left, right);
    }


    Node query(int ind, int low, int high, int l, int r) {
        //No overlap
        // [low high] {l r} OR {l r} [low high]
        if (l > high || r < low) return new Node();
        //Complete overlap
        // {l [low high] r}
        if (l <= low && r >= high) return seg[ind];
        //Partial overlap
        // [low {l high] r} OR {l [low r} high]
        int mid = (low + high) >> 1;
        Node left = query(2 * ind + 1, low, mid, l, r);
        Node right = query(2 * ind + 2, mid + 1, high, l, r);
        return merge(left, right);
    }

}

class Node {
    final int open;
    final int close;
    final int full;

    Node(int o, int c, int f) {
        open = o;
        close = c;
        full = f;
    }

    Node() {
        open = 0;
        close = 0;
        full = 0;
    }
}