public class Prince {
    int ans = Integer.MAX_VALUE;
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length,columns = dungeon[0].length;
        boolean visited[][] = new boolean[rows][columns];
        DFS(0,0,dungeon,visited,rows,columns,0);
        return ans+1;
    }
    private void DFS(int row,int col,int[][]dungeon,boolean [][]visited,int R,int C,int cal){
        if(row==R-1 && col==C-1)
        {
            ans = Math.min(ans,Math.abs(0-(cal+dungeon[row][col])));
            return;
        }
        else{
            visited[row][col]  = true;
            cal+=dungeon[row][col];
            int rIndex [] = {1,0};
            int cIndex [] = {0,1};
            for(int i=0;i<2;i++)
            {
                if(isValid(row+rIndex[i],col+cIndex[i],visited,R,C))
                    DFS(row+rIndex[i],col+cIndex[i],dungeon,visited,R,C,cal);
            }
            visited[row][col] = false;
            cal-=dungeon[row][col];
        }
    }
    private boolean isValid(int row,int col,boolean[][]visited,int R,int C){
        return row>=0&&row<R && col>=0&&col<C && !visited[row][col];
    }

    public static void main(String[] args) {
        int mat[][] = {
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}};
        Prince obj = new Prince();
        System.out.println(obj.calculateMinimumHP(mat));
    }

}