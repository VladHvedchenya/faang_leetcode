package solutions.SlidingWindow.S1763;

class Solution {
    public String longestNiceSubstring(String s) {
        String longestNice = "";
        int n = s.length();

        for (int i = 0; i < n; i++){
            boolean[] upperCase = new boolean[26];
            boolean[] lowerCase = new boolean[26];

            for (int j = i; j < n; j++){
                char symbol = s.charAt(j);

                if (Character.isUpperCase(symbol))
                    upperCase[symbol - 'A'] = true;
                else
                    lowerCase[symbol - 'a'] = true;


                if (hasAllPairs(lowerCase, upperCase))
                    if (j - i + 1 > longestNice.length()) {
                        longestNice = s.substring(i, j + 1);
                    }
            }
        }

        return longestNice;
    }

    private boolean hasAllPairs(boolean[] lowerCase, boolean[] upperCase) {
        for (int i = 0; i < 26; i++) {
            if (lowerCase[i] && !upperCase[i] || upperCase[i] && !lowerCase[i]) {
                return false;
            }
        }

        return true;
    }
}

//Time Complexity: O(n^3)
//Space Complexity: O(1)