public class Catalan {
    private int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        int index = 0;
        for (int i = 2; i <= n; i++) {
            index = i;
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[i - j] * dp[i - index];
                index--;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Catalan().numTrees(4));
    }
}