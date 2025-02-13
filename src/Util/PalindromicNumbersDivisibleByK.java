package Util;

public class PalindromicNumbersDivisibleByK {
    public static void main(String[] args) {
        int dig = 20;
        for (int i = 2; i < dig; i++) {
            System.out.print(i + " -> ");
            long x = i;
            long n = 0;
            while(x-->0) {
                n = n * 10 + 9;
            }
            while(n > 11) {
                if(n % 7 == 0) {
                    if(checkPalindrome(n)) {
                        System.out.println(n);
                        break;
                    }
                }
                n--;
            }
        }
    }
    public static boolean checkPalindrome(long n)
    {
        long reverse = 0;
        long temp = n;
        while (temp != 0) {
            reverse = (reverse * 10) + (temp % 10);
            temp = temp / 10;
        }
        return (reverse == n);
    }
}