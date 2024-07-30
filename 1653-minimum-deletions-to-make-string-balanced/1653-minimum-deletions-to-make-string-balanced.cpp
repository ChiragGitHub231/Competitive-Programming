class Solution {
public:
    int minimumDeletions(string s) {
        int ps[2][s.size()+1];
        ps[0][0] = ps[1][0] = 0;
        
        for(int i=0; i<s.size(); i++){
            ps[0][i+1] = ps[0][i] + (s[i] == 'a');
            ps[1][i+1] = ps[1][i] + (s[i] == 'b');
        }
        
        int ans = s.size();
        for(int i=0; i<=s.size(); i++){
            int left = ps[1][i];
            int right = ps[0][s.size()] - ps[0][i];
            ans = min(ans, left + right);
        }
        
        return ans;
    }
};