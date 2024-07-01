class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(i+2<n && arr[i]%2==1 && arr[i+1]%2==1 && arr[i+2]%2==1) return true;
        }
        return false;
    }
}