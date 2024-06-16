class Solution {
public:
    int minPatches(vector<int>& nums, int n) {
        long long sum=0, patches=0, index=0;
        while(sum<n){
            if(index<nums.size() && nums[index]<=sum+1) sum+=nums[index++];
            else {
                patches++;
                sum+=sum+1;
            }
        }
        return patches;
    }
};