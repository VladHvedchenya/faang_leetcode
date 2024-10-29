package solutions.SlidingWindow.S567;

import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] symbols1 = new int[26];
        int[] symbols2 = new int[26];

        for (char symbol : s1.toCharArray()) {
            symbols1[symbol - 'a']++;
        }

        for (int i = 0; i < s1.length(); i++) {
            symbols2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(symbols1, symbols2))
            return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            symbols2[s2.charAt(i) - 'a']++;
            symbols2[s2.charAt(i - s1.length()) - 'a']--;

            if (Arrays.equals(symbols1, symbols2))
                return true;

        }

        return false;
    }
}

//Time Complexity: O(n + k)
//Space Complexity: O(1)