class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strs = sentence.split(" ");
        for(int i=0; i<strs.length; i++) {
            String word = strs[i];
            if(word.length() < searchWord.length()) continue;
            if(searchWord.equals(word.substring(0, searchWord.length()))) return i+1;
        }
        return -1;
    }
}