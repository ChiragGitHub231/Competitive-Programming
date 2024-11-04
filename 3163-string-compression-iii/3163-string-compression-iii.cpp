class Solution {
public:
    string compressedString(string word) {
        string comp;
        int i = 0, n = word.length();
        while(i < n) {
            int counter = 0;
            char ch = word[i];
            while(i < n && word[i] == ch && counter < 9) {
                counter++;
                i++;
            }
            comp += to_string(counter) + ch;
        }
        return comp;
    }
};