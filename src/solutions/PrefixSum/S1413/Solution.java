package solutions.PrefixSum.S1413;

class Solution {
    public int minStartValue(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        int min = 0;

        for (int i = 1; i < prefixSum.length; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            min = Math.min(min, prefixSum[i]);
        }

        return min < 0 ? min * -1 + 1 : 1;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)