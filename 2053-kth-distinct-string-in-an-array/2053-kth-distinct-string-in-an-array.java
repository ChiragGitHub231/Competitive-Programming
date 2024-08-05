class Solution {
    public String kthDistinct(String[] arr, int k) {
        String ans = "";
        Map<String, Integer> mp = new LinkedHashMap<>();
        
        for(String str : arr){
            if(mp.containsKey(str)) mp.put(str, mp.get(str) + 1);
            else mp.put(str, 1);
        }
        
        for(Map.Entry<String, Integer> entry : mp.entrySet()){
            if(entry.getValue() == 1){
                if(--k == 0) {
                    ans = entry.getKey();
                    break;
                }
            }
        }
        
        return ans;
    }
}