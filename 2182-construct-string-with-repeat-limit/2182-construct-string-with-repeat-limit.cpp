class Solution {
public:
    string repeatLimitedString(string s, int repeatLimit) {
        int frequency[26] = {0};
        for(int i=0; i<s.size(); i++) frequency[s[i] - 'a']++;
        string ans(s.size(), '_');
        int k = 0;
        set<int> S;
        
        for(int i=25; i>=0; i--) {
            int counter = 0, current = 0;
            while(counter < frequency[i] && S.size()) {
                ans[*S.begin()] = (i + 'a');
                S.erase(S.begin());
                counter++;
            }
            
            while(counter < frequency[i]) {
                if(current == repeatLimit) S.insert(k), k++, current = 0;
                if(k > s.size()) break;
                ans[k] = (i + 'a');
                k++, current++, counter++;
            }
        }
        
        for(int i=0; i<ans.size(); i++) {
            if(ans[i] == '_') {
                ans.erase(ans.begin() + i, ans.end());
                break;
            }
        }
        
        return ans;
    }
};