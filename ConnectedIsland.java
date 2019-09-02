public class ConnectedIsland {
    private boolean isSafe(char [][] grid,int r,int c,int ROW,int COL,boolean [][] visited){
        return (r<ROW)&&(r>=0)&&(c>=0)&&(c<COL)&&(grid[r][c]=='1' && !visited[r][c]);
    }
    private void DFS(char [][] grid,boolean [][]visited,int r,int c,int ROW,int COL){
        int [] rowPos =new int[]{0,0,-1,1};  //only for horizontal && vertical
        int [] colPos = new int[]{1,-1,0,0};  //only for horizontal && vertical
        visited[r][c] = true;
        for(int i=0;i<4;i++)
        {
            if(isSafe(grid,r+rowPos[i],c+colPos[i],ROW,COL,visited))
                DFS(grid,visited,r+rowPos[i],c+colPos[i],ROW,COL);
        }
    }
    public int numIslands(char[][] grid) {
        if(grid.length==0)
            return 0;
        boolean [] [] visited = new boolean[grid.length][grid[0].length];
        int island=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]=='1'&& !visited[i][j]){
                    DFS(grid,visited,i,j,grid.length,grid[i].length);
                    island++;
                }
            }
        }
        return island;
    }

    public static void main(String[] args) {
        System.out.println(new ConnectedIsland().numIslands(new char [] []{ {'1','1','1','0','0'},
                                                                            {'1','1','0','1','0'},
                                                                            {'1','1','0','0','0'},
                                                                            {'0','0','0','0','0'}}));
    }
}