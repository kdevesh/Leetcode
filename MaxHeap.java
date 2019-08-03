class Point{
    int x,y,dist;
    public Point(int x,int y,int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
class BuildHeap {

    // To heapify a subtree rooted with node i which is
    // an index in arr[].Nn is size of heap
    Point arr[];
    int n;
    public BuildHeap(Point [] arr,int size){
        this.arr = arr;
        this.n = size;
    }
    public void heapify(int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l].dist > arr[largest].dist)
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r].dist > arr[largest].dist)
            largest = r;

        // If largest is not root
        if (largest != i) {
            Point swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(largest);
        }
    }

    // Function to build a Max-Heap from the Array
    public void buildHeap()
    {
        // Index of last non-leaf node
        int startIdx = (n / 2) - 1;

        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int i = startIdx; i >= 0; i--) {
            heapify(i);
        }
    }

    // A utility function to print the array
    // representation of Heap
    public int [][] getHeap()
    {
        int result [] [] = new int[n][2];
        for (int i = 0; i < n; ++i) {
            result[i][0] = arr[i].x;
            result[i][1] = arr[i].y;
        }
        return result;
    }
}

public class MaxHeap {
    public int[][] kClosest(int[][] points, int K) {
        Point dist [] = new Point [points.length];
        for(int i=0;i<points.length;i++)
        {
            dist[i] = new Point(points[i][0],points[i][1],(points[i][0]*points[i][0])+(points[i][1]*points[i][1]));
        }
        BuildHeap obj = new BuildHeap(dist,K);
        obj.buildHeap();
        for(int i=K;i<dist.length;i++)
        {
            if(dist[0].dist>dist[i].dist)
            {
                dist[0]=dist[i];
                obj.heapify(0);
            }
        }
        return obj.getHeap();
    }

    public static void main(String[] args) {
        MaxHeap obj = new MaxHeap();
        int K=2;
        int output [] [] = obj.kClosest(new int [] [] {{3,3},{5,-1},{-2,4}},K);
        for(int i=0;i<K;i++)
            System.out.println("["+output[i][0]+" "+output[i][1]+"]");
    }
}