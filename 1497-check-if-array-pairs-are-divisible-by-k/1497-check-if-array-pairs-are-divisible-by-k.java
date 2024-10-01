class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] rems = new int[k];
        for(int num : arr){
            if(num < 0) num = k - (Math.abs(num) % k);
            int complement = (k - (num % k)) % k;
            if(rems[complement] > 0) rems[complement]--;
            else rems[num % k]++;
        }
        
        for(int num : rems){
            if(num != 0) return false;
        }
        
        return true;
    }
}