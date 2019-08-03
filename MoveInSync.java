import java.util.*;
public class MoveInSync {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        while (T!=0)
        {
            int m,n,k,resultO=0,resultX=0;
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();
            String mat [] [] = new String [m][n];
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                    mat [i][j] = sc.next();
            }
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    int countXhorizonatal=0,countOhorizontal=0,countXvertical=0,countOvertical=0,countXdiag=0,countOdiag=0;
                    for(int x =0;x<k;x++)
                    {
                        if(j+x<n) {
                            if (mat[i][j + x].equals("x"))
                                countXhorizonatal++;
                            if (mat[i][j + x].equals("o"))
                                countOhorizontal++;
                        }
                        if(i+x<m) {
                            if (mat[i + x][j].equals("x"))
                                countXvertical++;
                            if (mat[i + x][j].equals("o"))
                                countOvertical++;
                        }
                        if(i+x<m&&j+x<n){
                            if (mat[i + x][j+x].equals("x"))
                                countXdiag++;
                            if (mat[i + x][j+x].equals("o"))
                                countOdiag++;
                        }
                        if(i+x<m && j-x>=0){
                            if (mat[i+x][Math.abs(j-x)].equals("x"))
                                countXdiag++;
                            if (mat[i+x][Math.abs(j-x)].equals("o"))
                                countOdiag++;
                        }
                    }
                    if(countOhorizontal==k)
                        resultO++;
                    if(countOvertical==k)
                        resultO++;
                    if(countOdiag==k)
                        resultO++;
                    if(countXhorizonatal==k)
                        resultX++;
                    if(countXvertical==k)
                        resultX++;
                    if(countXdiag==k)
                        resultX++;
                }
            }
            System.out.println(resultX +" "+resultO);
            T--;
        }
    }
}
