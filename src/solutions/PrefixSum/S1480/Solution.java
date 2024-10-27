package solutions.PrefixSum.S1480;

class Solution {
    public int[] runningSum(int[] nums) {
        int[] prefixSum = new int[nums.length];

        for (int i = 1; i < prefixSum.length; i++){
            prefixSum[i] = nums[i - 1] + nums[i];
        }

        return prefixSum;
    }
}
