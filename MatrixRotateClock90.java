public class MatrixRotateClock90 {
    public void rotate(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        swapDiagonal(matrix, row, col);
        swapRow(matrix, row, col);
    }

    public void swapDiagonal(int[][] matrix, int row, int col) {
        int cnt = 0;
        while (cnt < row) {
            int i = cnt, j = 0;
            while (i > j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
                i--;
                j++;
            }
            cnt++;
        }
        int k = row - 1, l = 1;
        while (k > l) {
            int i = k, j = l;
            while (i > j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
                i--;
                j++;
            }
            l++;
        }
    }

    public void swapRow(int[][] matrix, int row, int col) {
        int cnt = 0;
        while (cnt < row) {
            int i = cnt, z = 0, j = col - 1;
            while (z < j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][z];
                matrix[i][z] = tmp;
                z++;
                j--;
            }
            cnt++;
        }
    }

    public static void main(String[] args) {
        MatrixRotateClock90 obj = new MatrixRotateClock90();
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        System.out.println("Before");
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++)
                System.out.print(ints[j] + " ");
            System.out.println();
        }
        obj.rotate(matrix);
        System.out.println("After");
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++)
                System.out.print(ints[j] + " ");
            System.out.println();
        }
    }
}