package Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenerateVeryLargeMatrixString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < n; i++) {
            sb.append('[');
            for (int j = 0; j < n; j++) {
                sb.append('1');
                if(j != n - 1) sb.append(',');
            }
            sb.append(']');
            if(i != n - 1) sb.append(',');
        }
        System.out.println(sb);
    }
}