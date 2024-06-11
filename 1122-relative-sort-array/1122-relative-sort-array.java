class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer,Integer> mp=new TreeMap<Integer,Integer>();
        
        for(int num:arr1) mp.put(num,mp.getOrDefault(num,0)+1);
        
        int index=0;
        for(int num:arr2){
            int counter=mp.get(num);
            while(counter-->0) arr1[index++]=num;
            mp.remove(num);
        }
        
        for(int key:mp.keySet()){
            int value=mp.get(key);
            while(value-->0) arr1[index++]=key;
        }
        return arr1;
    }
}