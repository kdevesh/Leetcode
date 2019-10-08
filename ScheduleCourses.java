import java.util.*;

public class ScheduleCourses {
    private int[] schedule(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        int[] ingoing = new int[numCourses];
        int[] output = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> temp = mp.getOrDefault(src, new ArrayList<>());
            temp.add(dest);
            mp.put(src, temp);
            ingoing[dest]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (ingoing[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()) {
            int element = queue.remove();
            output[index] = element;
            index++;
            if (mp.containsKey(element)) {
                List<Integer> temp = mp.get(element);
                for (int item : temp) {
                    ingoing[item]--;
                    if (ingoing[item] == 0)
                        queue.add(item);
                }
            }
        }
        if (index == numCourses)
            return output;
        return new int[]{};
    }

    public static void main(String[] args) {
        ScheduleCourses obj = new ScheduleCourses();
        int[] result = obj.schedule(4, new int[][]{{1, 0},
                {2, 0},
                {2, 3},
                {3, 1}});
        Arrays.stream(result).forEach(val -> System.out.print(val + " "));
    }
}