//package Codeforces.Codeforces950;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//import java.util.TreeSet;
//
//import com.google.common.collect.HashMultiset;
//import com.google.common.collect.Multiset;
//
//public class SofiaAndTheLostOperations {
//    static final FastReader sc = new FastReader();
//
//    public static void main(String[] args) {
//        int t = sc.nextInt();
//        while (t-- > 0) {
//            solve();
//        }
//    }
//
//    static void solve() {
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[] initial = new int[n];
//        int[] modified = new int[n];
//        fill(initial);
//        fill(modified);
//        int[] canChange = new int[m];
//        fill(canChange);
//        Multiset<Integer> notEqual = HashMultiset.create();
//        Multiset<Integer> all = HashMultiset.create();
//        for (int i = 0; i < n; i++) {
//            if (initial[i] != modified[i]) {
//                notEqual.add(modified[i]);
//            }
//            all.add(modified[i]);
//        }
//        boolean c = false;
//        for (int x : canChange) {
//            if (notEqual.contains(x)) {
//                notEqual.remove(x);
//                continue;
//            }
//            if (all.contains(x)) {
//                if (c) {
//                    c = false;
//                }
//                continue;
//            }
//            if (notEqual.isEmpty()) {
//                c = true;
//            }
//        }
//        if (notEqual.isEmpty() && !c) {
//            System.out.println("yes");
//        } else {
//            System.out.println("no");
//        }
//    }
//
//    static class FastReader {
//        final BufferedReader br;
//        StringTokenizer st;
//
//        public FastReader() {
//            br = new BufferedReader(new InputStreamReader(System.in));
//        }
//
//        String next() {
//            while (st == null || !st.hasMoreElements()) {
//                try {
//                    st = new StringTokenizer(br.readLine());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return st.nextToken();
//        }
//
//        int nextInt() {
//            return Integer.parseInt(next());
//        }
//
//        long nextLong() {
//            return Long.parseLong(next());
//        }
//
//        double nextDouble() {
//            return Double.parseDouble(next());
//        }
//
//        String nextLine() {
//            String str = "";
//            try {
//                if (st.hasMoreTokens()) str = st.nextToken("\n");
//                else str = br.readLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return str;
//        }
//    }
//
//    static void fill(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = sc.nextInt();
//        }
//    }
//}
