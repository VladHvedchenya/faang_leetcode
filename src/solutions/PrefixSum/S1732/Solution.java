package solutions.PrefixSum.S1732;

class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int[] prefixSum = new int[gain.length + 1];

        for (int i = 1; i < prefixSum.length; i++){
            prefixSum[i] = prefixSum[i - 1] + gain[i - 1];
            max = Math.max(max, prefixSum[i]);
        }

        return max;
    }
}


//Time Complexity: O(n);
//Space Complexity: O(n);