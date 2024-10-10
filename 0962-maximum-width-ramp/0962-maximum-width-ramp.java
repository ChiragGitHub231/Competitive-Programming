class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            if(st.isEmpty() || nums[st.getLast()] > nums[i]) st.push(i);
        }
        
        int result = 0;
        for(int j=n-1; j>=0; j--){
            while(!st.isEmpty() && nums[st.getLast()] <= nums[j]){
                result = Math.max(result, j - st.getLast());
                st.pop();
            }
        }
        
        return result;
    }
}