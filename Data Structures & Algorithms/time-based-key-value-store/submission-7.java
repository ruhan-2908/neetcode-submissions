class Pair
{
    String emotion;
    int timeStamp;
    Pair(String emotion, int timeStamp)
    {
        this.emotion = emotion;
        this.timeStamp = timeStamp;
    }
}
class TimeMap {
    HashMap<String,List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key,k-> new ArrayList<>()).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        int i = 0;
        List<Pair> temp = map.get(key);
        int j = temp.size()-1;
        String res = "";
        while(i<=j)
        {
            int mid = i + (j-i)/2;
            if(temp.get(mid).timeStamp == timestamp)
            {
                return temp.get(mid).emotion;
            }
            if(temp.get(mid).timeStamp < timestamp)
            {
                res = temp.get(mid).emotion;
                i += 1;
            }else
            {
                j--;
            }
        }
        return res;
    }
}
