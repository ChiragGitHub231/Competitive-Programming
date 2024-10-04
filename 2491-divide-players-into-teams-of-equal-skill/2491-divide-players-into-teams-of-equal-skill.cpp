class Solution {
public:
    long long dividePlayers(vector<int>& skill) {
        sort(skill.begin(), skill.end());
        int n = skill.size();
        long long sum = skill[0] + skill[n-1], ans = 0;
        
        int i = 0, j = n - 1;
        while(i < j){
            long long temp = skill[i] + skill[j];
            if(temp != sum) return -1;
            ans += skill[i] * skill[j];
            i++;
            j--;
        }
        
        return ans;
    }
};