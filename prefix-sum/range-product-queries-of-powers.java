import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        int temp = n;
        while (temp > 0) {
            int powerOf2 = temp & -temp;
            powers.add(powerOf2);
            temp -= powerOf2;
        }

        int m = powers.size();
        long[] prefixProducts = new long[m + 1];
        prefixProducts[0] = 1;
        long mod = 1_000_000_007;

        for (int i = 0; i < m; i++) {
            prefixProducts[i + 1] = (prefixProducts[i] * powers.get(i)) % mod;
        }

        int[] answers = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            long product = (prefixProducts[right + 1] * modInverse(prefixProducts[left], mod)) % mod;
            answers[i] = (int) product;
        }

        return answers;
    }

    private long modInverse(long n, long mod) {
        return power(n, mod - 2, mod);
    }

    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}