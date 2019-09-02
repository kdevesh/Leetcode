import java.util.*;
public class Connected {
    int V;
    List<Integer>[] arr;
    Connected(int V) {
        this.V = V;
        arr = new LinkedList[V];
        for (int i = 0;i<arr.length;i++)
            arr[i] = new LinkedList<>();
    }
    public void addEdge(int parent,int child){
        arr[parent].add(child);
    }
    private void checkConnected(int node,boolean [] visited){
        visited[node]=true;
        List<Integer> temp  = arr[node];
        for(Integer val:temp){
            if(!visited[val])
                checkConnected(val, visited);
        }
    }
    public boolean isConnected(){
        boolean [] visited = new boolean[arr.length];
        int count = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(!visited[i]) {
                checkConnected(i, visited);
                count++;
            }
        }
        return count==1;
    }

    public static void main(String[] args) {
        Connected obj = new Connected(4);
        obj.addEdge(0,1);
        obj.addEdge(0,2);
        obj.addEdge(1,2);
        obj.addEdge(2,3);
        System.out.println(obj.isConnected());
    }
}
