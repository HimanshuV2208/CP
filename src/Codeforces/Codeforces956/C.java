package Codeforces.Codeforces956;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.ceilDiv;

public class C {
    static final FastReader sc = new FastReader();
    static final int P_INF = Integer.MAX_VALUE;
    static final int N_INF = Integer.MIN_VALUE;
    static final int MOD = 1_000_000_007;
    static long[] ans = new long[6];

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();
        long[] a = _inpArrLong(n);
        long[] b = _inpArrLong(n);
        long[] c = _inpArrLong(n);
        long total = 0L;
        for (long l : a) {
            total += l;
        }
        long tar = ceilDiv(total, 3);
        for (int i = 0; i < 6; ++i) {
            boolean flag = switch (i) {
                case 0 -> solveInternal(a, b, c, tar);
                case 1 -> solveInternal(a, c, b, tar);
                case 2 -> solveInternal(b, a, c, tar);
                case 3 -> solveInternal(b, c, a, tar);
                case 4 -> solveInternal(c, a, b, tar);
                case 5 -> solveInternal(c, b, a, tar);
                default -> false;
            };
            if (flag) {
                ans[5] = n;
                printSolution(i);
                return;
            }
        }
        System.out.println(-1);
    }

    static boolean solveInternal(long[] a, long[] b, long[] c, long tar) {
        boolean[] flag = {false, false, false};
        int n = a.length;
        int j = 0;
        long sum = 0;
        ans[0] = 1;
        while (j < n) {
            sum += a[j];
            ans[1] = j + 1;
            if (sum >= tar) {
                ++j;
                flag[0] = true;
                break;
            }
            j++;
        }
        if(!flag[0]) return false;
        sum = 0;
        ans[2] = j + 1;
        while (j < n) {
            sum += b[j];
            ans[3] = j + 1;
            if (sum >= tar) {
                ++j;
                flag[1] = true;
                break;
            }
            j++;
        }
        if(!flag[1]) return false;
        sum = 0;
        ans[4] = j + 1;
        while (j < n) {
            sum += c[j];
            ans[5] = j + 1;
            if (sum >= tar) {
                ++j;
                flag[2] = true;
                break;
            }
            j++;
        }
        return flag[2];
    }

    private static void printSolution(int i) {
        int[][] permutations = {
                {0, 1, 2, 3, 4, 5},
                {0, 1, 4, 5, 2, 3},
                {2, 3, 0, 1, 4, 5},
                {4, 5, 0, 1, 2, 3},
                {2, 3, 4, 5, 0, 1},
                {4, 5, 2, 3, 0, 1}
        };

        StringBuilder sb = new StringBuilder();
        for (int index : permutations[i]) {
            sb.append(ans[index]).append(" ");
        }
        System.out.println(sb.toString().trim());
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
