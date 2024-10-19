class Solution {
public:
    string reversi(string t) {
        reverse(t.begin(), t.end());
        return t;
    }
    
    string inverti(string q) {
        for(int i=0; i<q.size(); i++) {
            if(q[i] == '0') q[i] = '1';
            else q[i] = '0';
        }
        return q;
    }
    
    char findKthBit(int n, int k) {
        vector<string> v(n+1);
        string s;
        v[0] = "0";
        v[1] = "011";
        
        for(int i=2; i<n; i++) v[i] = v[i-1] + '1' + reversi(inverti(v[i-1]));
        
        s = v[n-1];
        return s[k - 1];
    }
};