package Codeforces.Codeforces943;

//You are given an integer x Your task is to find any integer y (1≤y<x)
// such that gcd(x,y)+y is maximum possible.
//
//Note that if there is more than one y
// which satisfies the statement, you are allowed to find any.
// gcd(a,b) is the Greatest Common Divisor of a and b
//. For example, gcd(6,4)=2
//Input
//The first line contains a single integer t
// (1≤t≤1000
//) — the number of test cases.
//
//Each of the following t
// lines contains a single integer x
// (2≤x≤1000
//).
//
//Output
//For each test case, output any y
// (1≤y<x
//), which satisfies the statement.
//
//Example
//inputCopy
//7
//10
//7
//21
//100
//2
//1000
//6
//outputCopy
//5
//6
//18
//98
//1
//750
//3


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Maximize {
    static final FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        int x = sc.nextInt();
        int maxVal = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        for (int y = x-1; y >= 1; y--) {
            int gcdVal = gcd(x, y);
            if(gcdVal + y > maxVal) {
                maxVal = gcdVal + y;
                maxY = y;
            }
        }
        System.out.println(maxY);
    }

    static int gcd(int a, int b)
    {
        int result = Math.min(a, b);
        while (result > 0) {
            if (a % result == 0 && b % result == 0) {
                break;
            }
            result--;
        }
        return result;
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

