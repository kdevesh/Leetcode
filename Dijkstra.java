import java.util.*;

class Dijkstra {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] dijkstra = new int[n + 1][n + 1];
        List<Integer> visited = new ArrayList<>();
        visited.add(k);
        int[] values = new int[n + 1];
        Arrays.fill(values, Integer.MAX_VALUE);
        List<Integer> unvisited = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i != k)
                unvisited.add(i);
        }
        for (int[] row : dijkstra)
            Arrays.fill(row, 1000000);
        for (int i = 1; i <= times.length; i++)
            dijkstra[times[i - 1][0]][times[i - 1][1]] = times[i - 1][2];
        for (int i = 1; i <= n; i++) {
            if (i != k && dijkstra[k][i] != 1000000)
                values[i] = dijkstra[k][i];
        }
        int minWeight = getMinWeights(values, visited);
        while (!unvisited.isEmpty() && minWeight != -1) {
            for (int i = 1; i <= n; i++) {
                if (!visited.contains(i) && dijkstra[minWeight][i] + dijkstra[k][minWeight] < dijkstra[k][i]) {
                    dijkstra[k][i] = dijkstra[minWeight][i] + dijkstra[k][minWeight];
                    values[i] = dijkstra[k][i];
                }
            }
            unvisited.remove(new Integer(minWeight));
            visited.add(minWeight);
            minWeight = getMinWeights(values, visited);
            if (minWeight == -1)
                break;
        }
        int max = 0, cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (values[i] == Integer.MAX_VALUE)
                cnt++;
        }
        for (int i = 1; i <= n; i++) {
            if (values[i] > max && values[i] != Integer.MAX_VALUE)
                max = values[i];

        }
        if (cnt > 1 || max == 0)
            return -1;
        return max;

    }

    public int getMinWeights(int[] values, List<Integer> visited) {
        int min = Integer.MAX_VALUE;
        int node = 0;
        for (int i = 1; i < values.length; i++) {
            if (!visited.contains(i) && values[i] < min) {
                min = values[i];
                node = i;
            }
        }
        if (node == 0)
            return -1;
        return node;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,1},{2,3,2},{1,3,1}};
        Dijkstra obj = new Dijkstra();
        System.out.println(obj.networkDelayTime(mat, 3, 2));
    }
}