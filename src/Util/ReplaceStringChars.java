package Util;

public class ReplaceStringChars {
    static String replace(String s, char find, char replace) {
        int n = s.length();
        StringBuilder replaced = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == find) replaced.append(replace);
            else replaced.append(s.charAt(i));
        }
        return replaced.toString();
    }

    public static void main(String[] args) {
        String s = "{{187,167,209,251,152,236,263,128,135},{267,249,251,285,73,204,70,207,74},{189,159,235,66,84,89,153,111,189},{120,81,210,7,2,231,92,128,218},{193,131,244,293,284,175,226,205,245}}";
        s = replace(s, '{', '[');
        s = replace(s, '}', ']');
        System.out.println(s);
    }
}


