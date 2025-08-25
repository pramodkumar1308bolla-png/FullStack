package exam;


import java.util.Scanner;

public class ConvexPolygons {
    static final int MOD = 1234567;

    static long modExp(long base, long exp, int mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                scanner.nextInt();
                scanner.nextInt();
            }

            if (n < 3) {
                System.out.println(0);
                continue;
            }

            long totalSubsets = modExp(2, n, MOD);
            long subtract = (1 + n + (long) n * (n - 1) / 2) % MOD;
            long result = (totalSubsets - subtract) % MOD;
            
            if (result < 0) {
                result += MOD;
            }

            System.out.println(result);
        }

        scanner.close();
    }
}
