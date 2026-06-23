class CountSquares {
    HashMap<Integer,HashMap<Integer,Integer>> map;
    public CountSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        map.putIfAbsent(point[0],new HashMap<>());
        map.get(point[0]).put(point[1],map.get(point[0]).getOrDefault(point[1],0)+1);
    }
    
    public int count(int[] point) {
        int a = point[0];
        int b = point[1];
        int res = 0;
        if(!map.containsKey(a)) return 0;
        for(int b2 : map.get(a).keySet())
        {
            int x = b2 - b;
            if(x == 0) continue;

            int a3 = a + x;
            int a4 = a - x;

            res += map.get(a).get(b2) *
                   map.getOrDefault(a3,new HashMap<>()).getOrDefault(b,0) *
                   map.getOrDefault(a3,new HashMap<>()).getOrDefault(b2,0);


            res += map.get(a).get(b2) *
                   map.getOrDefault(a4,new HashMap<>()).getOrDefault(b,0) *
                   map.getOrDefault(a4,new HashMap<>()).getOrDefault(b2,0);

        }

        return res;
    }
}
