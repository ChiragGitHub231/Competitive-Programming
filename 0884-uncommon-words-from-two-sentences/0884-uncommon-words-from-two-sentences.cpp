class Solution {
public:
    vector<string> uncommonFromSentences(string s1, string s2) {
        unordered_map<string, int> mp;
        vector<string> ans;
        string temp = s1 + ' ' + s2;
        string p = "";
        for(int i=0; i<temp.size(); i++){
            if(temp[i] == ' '){
                mp[p]++;
                p = "";
            } else p += temp[i];
        }
        mp[p]++;
        for(auto &it : mp) {
            if(it.second == 1) ans.push_back(it.first);
        }
        return ans;
    }
};