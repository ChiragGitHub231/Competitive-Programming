class Solution {
public:
    string removeSubstring(string s, string str, int points, int &ans){
        stack<char>st;
        int n=s.length();
        for(int i=0; i<n; i++){
            if(s[i]==str[1] && !st.empty() && st.top()==str[0]){
                st.pop();
                ans+=points;
            } else st.push(s[i]);
        }
        string ss="";
        while(!st.empty()){
            ss+=st.top();
            st.pop();
        }
        reverse(ss.begin(), ss.end());
        return ss;
    }
    
    int maximumGain(string s, int x, int y) {
        int ans=0;
        if(x<y){
            s=removeSubstring(s,"ba",y,ans);
            s=removeSubstring(s,"ab",x,ans);
        } else {
            s=removeSubstring(s,"ab",x,ans);
            s=removeSubstring(s,"ba",y,ans);
        }
        return ans;
    }
};