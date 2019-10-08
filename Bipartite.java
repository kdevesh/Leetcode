import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    public boolean isBipartite(int[][] graph) {
        int []colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1) {
                if (!bipartiteUtil(graph, i, colors))
                    return false;
            }
        }
        return true;

    }

    public boolean bipartiteUtil(int[][] graph, int src, int[] colors) {
        colors[src] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int i = 0; i < graph[v].length; i++) {
                if (colors[graph[v][i]] == -1) {
                    colors[graph[v][i]] = 1 - colors[v];
                    q.add(graph[v][i]);
                } else {
                    if (colors[graph[v][i]] == colors[v])
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Bipartite bipartite = new Bipartite();
        System.out.println(bipartite.isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
    }
}