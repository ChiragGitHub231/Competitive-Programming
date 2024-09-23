class Solution {
public:
    int minExtraChar(string s, vector<string>& dictionary) {
        int m = s.length(), n = dictionary.size();
        vector<int> result(m+1, 0);
        for(int i=1; i<=m; i++){
            result[i] = result[i-1] + 1;
            for(int j=i; j>=1; j--){
                string temp = s.substr(j-1, i-j+1);
                if(find(dictionary.begin(), dictionary.end(), temp) != dictionary.end()){
                    result[i] = min(result[i], result[j-1]);
                }
            }
        }
        return result[m];
    }
};