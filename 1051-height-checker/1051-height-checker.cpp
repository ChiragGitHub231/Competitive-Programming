class Solution {
public:
    int heightChecker(vector<int>& heights) {
        int counter=0;
        vector<int> expected;
        expected=heights;
        sort(expected.begin(),expected.end());
        for(int i=0; i<heights.size(); i++){
            if(heights[i]!=expected[i]) counter++;
        }
        return counter;
    }
};