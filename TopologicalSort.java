// A Java program to print topological sorting of a DAG
import java.util.*;

// This class represents a directed graph using adjacency
// list representation
public class TopologicalSort
{
    private int V; // No. of vertices
    private LinkedList<Integer> []adj; // Adjacency List
    private static TopologicalSort object;
    //Constructor
    private TopologicalSort(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList<>();
    }
    public static TopologicalSort getinstance(int v){
        if(object==null)
            return new TopologicalSort(v);
        return object;
    }

    // Function to add an edge into the graph
    private void addEdge(int v,int w) { adj[v].add(w); }

    // A recursive function used by topologicalSort
    private void topologicalSortUtil(int v, boolean [] visited,
                             Stack stack)
    {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this
        // vertex
         for(int item:adj[v]){
             if(!visited[item])
                 topologicalSortUtil(item,visited,stack);
         }
        // Push current vertex to stack which stores result
        stack.push(v);
    }

    // The function to do Topological Sort. It uses
    // recursive topologicalSortUtil()
    private void topologicalSort()
    {
        Stack stack = new Stack();

        // Mark all the vertices as not visited
        boolean []visited = new boolean[V];
        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for (int i = 0; i < V; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);

        // Print contents of stack
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    // Driver method
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        TopologicalSort g = TopologicalSort.getinstance(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.topologicalSort();
    }
}