/*
The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.
Each node is an integer between 0 and graph.length - 1.
There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
 */

import java.util.Arrays;

public class ColorGraph {
    public int[] colorGraph(int[][] graph) {
        int colors[] = new int[graph.length];
        Arrays.fill(colors, -1);
        boolean available[] = new boolean[graph.length];
        Arrays.fill(available, true);
        colors[0] = 0;
        for (int i = 1; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (colors[graph[i][j]] != -1)
                    available[colors[graph[i][j]]] = false;
            }
            int j = 0;
            for (j = 0; j < available.length; j++) {
                if (available[j])
                    break;
            }
            colors[i] = j;
            Arrays.fill(available, true);
        }
        return colors;
    }

    public static void main(String[] args) {
        ColorGraph colorGraph = new ColorGraph();
        int[] result = colorGraph.colorGraph(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}});
        for (int i = 0; i < result.length; i++) {
            System.out.println("Vertex:" + i + " color:" + result[i]);
        }
    }
}
