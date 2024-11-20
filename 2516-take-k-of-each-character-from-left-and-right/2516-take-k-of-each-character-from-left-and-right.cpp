class Solution {
public:
    int takeCharacters(string s, int k) {
        int counter[3] = {}, sz = size(s), result = -1;
        for(auto ch : s) counter[ch - 'a']++;
        
        if(*min_element(begin(counter), end(counter)) < k) return -1;
        
        for(int i=0, j=0; i<sz; i++) {
            if(--counter[s[i] - 'a'] < k) while(counter[s[i] - 'a'] < k) ++counter[s[j++] - 'a'];
            result = max(result, i - j + 1);
        }
        
        return sz - result;
    }
};