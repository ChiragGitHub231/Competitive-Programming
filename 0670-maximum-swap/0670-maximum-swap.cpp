class Solution {
public:
    int maximumSwap(int num) {
        if(num == 0) return 0;
        
        string str = to_string(num);
        int n = str.size(), maxInRight = str[n-1] - '0';
        
        vector<int> v(10, -1);
        for(int i=n-1; i>=0; i--) {
            if(str[i] - '0' < maxInRight) v[i] = maxInRight;
            maxInRight = max(maxInRight, str[i] - '0');
        }
        
        vector<int> v2(10, -1);
        for(int i=n-1; i>=0; i--) {
            if(v2[str[i] - '0'] == -1) v2[str[i] - '0'] = i;
        }
        
        for(int i=0; i<str.size(); i++) {
            if(v[i] != -1) {
                swap(str[i], str[v2[v[i]]]);
                break;
            }
        }
        
        return stoi(str);
    }
};