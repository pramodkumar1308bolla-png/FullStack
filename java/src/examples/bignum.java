package examples;

import java.util.Arrays;

public class bignum {
    public static void main(String[] args) {
        int n = 916837254;
        System.out.println("Biggest number: " + makeBiggest(n));
    }	

    public static int makeBiggest(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        Arrays.sort(digits);
        StringBuilder sb = new StringBuilder(new String(digits));
        return Integer.parseInt(sb.reverse().toString());
    }
}
