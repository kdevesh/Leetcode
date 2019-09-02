import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class CountWays {
    static int count = 0;
    static boolean flag = false;
}

public class King {
    private static boolean isSafe(String[][] grid, int r, int c, int size, boolean[][] visited) {
        return (r < size) && (r >= 0) && (c >= 0) && (c < size) && (!grid[r][c].equals("x") && !visited[r][c]);
    }

    private static int DFS(String[][] grid, boolean[][] visited, int r, int c, int size, int max, int ans) {
        int[] rowPos = new int[]{-1, 0, -1};
        int[] colPos = new int[]{0, -1, -1};
        if (!grid[r][c].equals("e"))
            visited[r][c] = true;
        for (int i = 0; i < 3; i++) {
            if (grid[r][c].equals("e")) {
                CountWays.flag = true;  // condition to check if there is atleast one path which reaches the destination
                return max;
            } else if (isSafe(grid, r + rowPos[i], c + colPos[i], size, visited)) {
                max += Integer.parseInt(grid[r][c]);
                int temp = DFS(grid, visited, r + rowPos[i], c + colPos[i], size, max, ans);
                ans = Math.max(temp, ans);
                visited[r + rowPos[i]][c + colPos[i]] = false;
                max -= Integer.parseInt(grid[r][c]);
            }
        }
        return ans;
    }

    /* Below function is added just to count the number of ways which lead to the maximum points*/
    private static int countWays(String[][] grid, boolean[][] visited, int r, int c, int size, int max, int ans, int desired) {
        int[] rowPos = new int[]{-1, 0, -1};
        int[] colPos = new int[]{0, -1, -1};
        if (!grid[r][c].equals("e"))
            visited[r][c] = true;
        for (int i = 0; i < 3; i++) {
            if (grid[r][c].equals("e")) {
                return max;
            } else if (isSafe(grid, r + rowPos[i], c + colPos[i], size, visited)) {
                max += Integer.parseInt(grid[r][c]);
                int temp = countWays(grid, visited, r + rowPos[i], c + colPos[i], size, max, ans, desired);
                ans = Math.max(temp, ans);
                if (max == desired)
                    CountWays.count++;
                visited[r + rowPos[i]][c + colPos[i]] = false;
                max -= Integer.parseInt(grid[r][c]);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader dd = new BufferedReader((new InputStreamReader(System.in)));
        int T;
        T = Integer.parseInt(dd.readLine());
        while (T != 0) {
            int N = Integer.parseInt(dd.readLine());
            String[][] mat = new String[N][N];
            for (int i = 0; i < N; i++) {
                String temp = dd.readLine();
                int j = 0;
                StringTokenizer st = new StringTokenizer(temp, " ");
                while (st.hasMoreTokens()) {
                    mat[i][j] = st.nextToken();
                    j++;
                }
            }
            boolean[][] visited = new boolean[N][N];
            int max = 0;
            mat[N - 1][N - 1] = "0";
            if (!mat[N - 1][N - 1].equals("x") && !visited[N - 1][N - 1]) {
                max = DFS(mat, visited, N - 1, N - 1, N, 0, 0);
            }
            if (CountWays.flag)
                countWays(mat, visited, N - 1, N - 1, N, 0, 0, max);
            System.out.println(max + " " + CountWays.count);
            CountWays.count = 0;
            CountWays.flag = false;
            T--;
        }
    }
}
