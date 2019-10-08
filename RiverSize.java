import java.util.ArrayList;
import java.util.Collections;

class RiverSize {
    private static boolean isValid(boolean[][] visited, int[][] matrix, int row, int col) {
            return row < matrix.length && row >= 0 && col < matrix[0].length && col >= 0 && !visited[row][col] && matrix[row][col] != 0;
    }

    private static void DFS(boolean[][] visited, int[][] matrix, int row, int col, int[] count) {
        visited[row][col] = true;
        int []ro = {-1, 1, 0, 0};
        int []co = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            if (isValid(visited, matrix, row + ro[i], col + co[i])) {
                DFS(visited, matrix, row + ro[i], col + co[i], count);
                count[0]++;
            }
        }
    }

    public static ArrayList<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        ArrayList<Integer> res = new ArrayList<>();
        boolean [][]visited = new boolean[matrix.length][matrix[0].length];
        int []count = new int[1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                count[0] = 1;
                if (!visited[i][j] && matrix[i][j] != 0) {
                    DFS(visited, matrix, i, j, count);
                    res.add(count[0]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] input = {
                {1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
                {1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1},
        };
        ArrayList<Integer> output = RiverSize.riverSizes(input);
        Collections.sort(output);
        output.forEach(val -> System.out.print(val + " "));
    }
}
