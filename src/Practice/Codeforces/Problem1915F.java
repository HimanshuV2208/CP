package Practice.Codeforces;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1915F {
    static final FastReader sc = new FastReader();
    static final int P_INF = Integer.MAX_VALUE;
    static final int N_INF = Integer.MIN_VALUE;
    static final int MOD = 1_000_000_007;
    static long ans = 0;

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            ans = 0;
            solve();
        }
    }

    static void solve() {
        List<int[]> intervals = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            intervals.add(new int[]{sc.nextInt(), sc.nextInt()});
        }
        intervals.sort(Comparator.comparingInt(a -> a[1]));
        int[] arr = new int[n];
        int c = 0;
        for (int[] interval : intervals){
            arr[c++] = interval[0];
        }
        mergeSort(arr, 0, n-1);
        System.out.println(ans);
    }

    static void mergeSort(int[] arr, int l, int r){
        if(l < r){
            int mid = l - (l - r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    static void merge(int[] arr, int l, int mid, int r){
        int n1 = mid - l + 1, n2 = r - mid;
        int[] a = new int[n1], b = new int[n2];
        for(int i = l; i <= r; i++){
            if(i <= mid) a[i - l] = arr[i];
            else b[i - mid - 1] = arr[i];
        }
        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2){
            if(a[i] <= b[j]) arr[k++] = a[i++];
            else {
                ans += n1 - i;
                arr[k++] = b[j++];
            }
        }
        while(i < n1) arr[k++] = a[i++];
        while(j < n2) arr[k++] = b[j++];
    }

    static void yeah() {
        System.out.println("YES");
    }

    static void nope() {
        System.out.println("NO");
    }

    static int[] _inpArr(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    static long[] _inpArrLong(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        return arr;
    }

    static void _printArr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int x : arr) sb.append(x).append(" ");
        System.out.println(sb);
    }

    static int[][] _inpGrid(int rows, int cols) {
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            grid[i] = _inpArr(cols);
        }
        return grid;
    }

    static void _printGrid(int[][] grid) {
        for (int[] row : grid) {
            _printArr(row);
        }
    }

    static boolean _isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        long sqrtN = (long) Math.sqrt(n) + 1;
        for (long i = 6L; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) return false;
        }
        return true;
    }

    static boolean[] _sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        return prime;
    }

    static long _gcd(long a, long b) {
        if (a > b) a = (a + b) - (b = a);
        if (a == 0L) return b;
        return _gcd(b % a, a);
    }

    static long _lcm(long a, long b) {
        return (a * b) / _gcd(a, b);
    }

    static long _power(long x, long y, long p) {
        long res = 1L;
        x = x % p;
        while (y > 0) {
            if ((y & 1) == 1) res = (res * x) % p;
            y >>= 1;
            x = (x * x) % p;
        }
        return res;
    }

    /**
     * <p><u><b>Random stuff to try when stuck:</b></u></p>
     * <p>-for combo/probability problems, expand the given form we're interested in</p>
     * <p>-make everything the same then build an answer (constructive, make everything 0 then do something)</p>
     * <p>-something appears in parts of 2 --> model as graph</p>
     * <p>-assume a greedy then try to show why it works</p>
     * <p>-find way to simplify into one variable if multiple exist</p>
     * <p>-treat it like fmc (note any passing thoughts/algo that could be used so you can revisit them)</p>
     * <p>-find lower and upper bounds on answer</p>
     * <p>-figure out what ur trying to find and isolate it</p>
     * <p>-see what observations you have and come up with more continuations</p>
     * <p>-work backwards (in constructive, go from the goal to the start)</p>
     * <p>-turn into prefix/suffix sum argument (often works if problem revolves around adjacent array elements)</p>
     * <p>-instead of solving for answer, try solving for complement (ex, find n-(min) instead of max)</p>
     * <p>-draw something</p>
     * <p>-simulate a process</p>
     * <p>-don't implement something unless if you're fairly confident its correct</p>
     * <p>-after 3 bad submissions move on to next problem if applicable</p>
     * <p>-do something instead of nothing and stay organized</p>
     * <p>-write stuff down</p>
     * <p><u><b>Random stuff to check when WA:</b></u></p>
     * <p>-if code is way too long/cancer then reassess</p>
     * <p>-switched N/M</p>
     * <p>-int overflow</p>
     * <p>-switched variables</p>
     * <p>-wrong MOD</p>
     * <p>-hardcoded edge case incorrectly</p>
     * <p><u><b>Random stuff to check when TLE:</b></u></p>
     * <p>-continue instead of break</p>
     * <p>-condition in for/while loop bad</p>
     * <p><u><b>Random stuff to check when RTE:</b></u></p>
     * <p>-switched N/M</p>
     * <p>-long to int/int overflow</p>
     * <p>-division by 0</p>
     * <p>-edge case for empty list/data structure/N=1</p>
     */
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


