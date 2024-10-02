class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] clone = arr.clone();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        Arrays.sort(clone);
        
        for(int a : clone) map.putIfAbsent(a, map.size() + 1);
        
        for(int i=0; i<arr.length; i++) clone[i] = map.get(arr[i]);
        
        return clone;
    }
}