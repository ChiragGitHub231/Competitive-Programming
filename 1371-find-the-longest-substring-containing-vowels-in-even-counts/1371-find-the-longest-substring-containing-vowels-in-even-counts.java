class Solution {
    public int findTheLongestSubstring(String s) {
        int[] vowelToBit = new int[26];
        vowelToBit['a' - 'a'] = 1 << 0;
        vowelToBit['e' - 'a'] = 1 << 1;
        vowelToBit['i' - 'a'] = 1 << 2;
        vowelToBit['o' - 'a'] = 1 << 3;
        vowelToBit['u' - 'a'] = 1 << 4;
        
        int mask = 0;
        int locs[] = new int[1 << 5];
        for(int i = 0; i < locs.length; i++) locs[i] = -2;
        
        locs[0] = -1;
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') mask ^= vowelToBit[ch - 'a'];
            if(locs[mask] != -2) result = Math.max(result, i - locs[mask]);
            else locs[mask] = i;
        }
        
        return result;
    }
}