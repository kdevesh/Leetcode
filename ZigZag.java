class ZigZag {
    public String convert(String s, int numRows) {
        String output = "";
        if (numRows == 1 || s.length() < numRows)
            return s;
        else {
            int columns = (int) Math.ceil((double) s.length() / (double) 2);
            char mat[][] = new char[numRows][columns];
            int k = 0, i = 0, j = 0;
            boolean swap = false;
            while (k < s.length()) {
                if (!swap) {
                    while (k < s.length() && i >= 0 && i < numRows) {
                        mat[i][j] = s.charAt(k);
                        k++;
                        i++;
                    }
                    swap = true;
                    i -= 2;
                } else {
                    while (k < s.length() && i >= 0 && j < columns) {
                        j++;
                        mat[i][j] = s.charAt(k);
                        k++;
                        i--;
                    }
                    swap = false;
                    i += 2;
                }
            }
            for (int m = 0; m < numRows; m++) {
                for (int n = 0; n < columns; n++) {
                    if (mat[m][n] != '\u0000')
                        output += mat[m][n];
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        ZigZag obj = new ZigZag();
        System.out.println(obj.convert("PAYPALISHIRING", 5));
    }
}
