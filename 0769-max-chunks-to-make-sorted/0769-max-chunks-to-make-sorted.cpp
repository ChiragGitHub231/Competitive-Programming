class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
        int max_value = 0, chunks = 0;
        for(int i=0; i<arr.size(); i++) {
            if(arr[i] > max_value) max_value = arr[i];
            if(max_value == i) chunks++;
        }
        return chunks;
    }
};