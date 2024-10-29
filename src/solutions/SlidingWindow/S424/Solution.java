package solutions.SlidingWindow.S424;

class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int maxCount = 0, left = 0, right = 0;

        for (right = 0; right < s.length(); right++){
            map[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, map[s.charAt(right) - 'A']);

            if (right - left + 1 - maxCount > k){
                map[s.charAt(left) - 'A']--;
                left++;
            }
        }

        return right - left;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)