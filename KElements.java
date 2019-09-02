import java.util.HashMap;

//subarray with 2 unique elements

class KElements {
    public int totalFruit(int[] tree) {
        int max=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int start=0;

        for(int i=0; i<tree.length; i++){
            int c = tree[i];
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c,1);
            }

            if(map.size()>2){
                max = Math.max(max, i-start);

                while(map.size()>2){
                    int t = tree[start];
                    int count = map.get(t);
                    if(count>1){
                        map.put(t, count-1);
                    }else{
                        map.remove(t);
                    }
                    start++;
                }
            }
        }

        max = Math.max(max, tree.length-start);

        return max;
    }

    public static void main(String[] args) {
        KElements obj = new KElements();
        System.out.println(obj.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}