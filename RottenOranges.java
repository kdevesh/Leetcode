import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Points {
    int row, col, value;

    Points(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }
}

public class RottenOranges {
    private static boolean isValid(boolean[][] visited, int[][] matrix, int row, int col) {
        return row < matrix.length && row >= 0 && col < matrix[0].length && col >= 0 && !visited[row][col] && matrix[row][col] != 0 && matrix[row][col] != 2;
    }

    public int orangesRotting(int[][] grid) {
        List<Points> rotten = new LinkedList<>();
        boolean fresh = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    rotten.add(new Points(i, j, grid[i][j]));
                else if (grid[i][j] == 1)
                    fresh = true;
            }
        }
        if (rotten.size() == 0 && fresh)
            return -1;
        else if (!fresh)
            return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Points> queue = new LinkedList<>();
        int ans = 0, left = 0;
        int[] ro = {-1, 1, 0, 0};
        int[] co = {0, 0, -1, 1};
        for (Points point:rotten) {
            queue.add(new Points(point.row, point.col, grid[point.row][point.col]));
        }
        visited[rotten.get(0).row][rotten.get(0).col] = true;
        while (!queue.isEmpty()) {
            int cap = queue.size();
            while (cap != 0) {
                Points poll = queue.poll();
                for (int i = 0; i < 4; i++) {
                    if (isValid(visited, grid, poll.row + ro[i], poll.col + co[i])) {
                        visited[poll.row + ro[i]][poll.col + co[i]] = true;
                        queue.add(new Points(poll.row + ro[i], poll.col + co[i], grid[poll.row + ro[i]][poll.col + co[i]]));
                    }
                }
                cap--;
            }
            ans++;
        }
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (!visited[i][j] && grid[i][j] != 0 && grid[i][j] != 2)
                    left++;
            }
        }
        if (left != 0)
            return -1;
        return ans - 1;
    }

    public static void main(String[] args) {
        int[][] input = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(new RottenOranges().orangesRotting(input));
    }
}