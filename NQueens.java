import java.util.LinkedList;
import java.util.List;

class Position {
    int row, col;

    Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class NQueens {
    public List<List<String>> solveNQueens(int n) {
        Position positions[] = new Position[n];
        List<List<String>> res = new LinkedList<>();
        List<String> temp = new LinkedList<>();
        boolean possible = helper(n, 0, positions);
        if (possible) {
            for (int i = 0; i < n; i++) {
                String str = "";
                for (int j = 0; j < n; j++) {
                    if (positions[i].row == i && positions[i].col == j)
                        str += "Q";
                    else
                        str += ".";
                }
                temp.add(str);
            }
            res.add(temp);
        }
        return res;
    }

    private boolean helper(int N, int row, Position[] positions) {
        if (N == row)
            return true;
        else {
            for (int i = 0; i < N; i++) {
                boolean isFound = true;
                for (int j = 0; j < row; j++) {
                    if (positions[j].col == i || positions[j].row - positions[j].col == row - i ||
                            positions[j].col + positions[j].row == row + i) {
                        isFound = false;
                        break;
                    }
                }
                if (isFound) {
                    positions[row] = new Position(row, i);
                    if (helper(N, row + 1, positions))
                        return true;
                }
            }
            return false;
        }
    }

}