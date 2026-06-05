class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] check1 = new int[26];
        for (char ch : s1.toCharArray()) check1[ch - 'a']++;
        int[] check2 = new int[26];
        for (int i = 0; i < s1.length(); i++) check2[s2.charAt(i) - 'a']++;
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (check1[i] == check2[i])
                matches++;
        }
        int start = 0;
        for (int end = s1.length(); end < s2.length(); end++) {
            if (matches == 26)
                return true;
            char ch = s2.charAt(start);
            check2[ch - 'a']--;
            if (check1[ch - 'a'] == check2[ch - 'a'])
                matches++;
            else if (check1[ch - 'a'] - 1 == check2[ch - 'a'])
                matches--;
            ch = s2.charAt(end);
            check2[ch - 'a']++;
            if (check1[ch - 'a'] == check2[ch - 'a'])
                matches++;
            else if (check1[ch - 'a'] + 1 == check2[ch - 'a'])
                matches--;
            start++;
        }
        return matches == 26;
    }
}