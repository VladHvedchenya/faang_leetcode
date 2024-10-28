package solutions.PrefixSum.S303;

class NumArray {
    private final int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0)
            return prefixSum[right];
        return prefixSum[right] - prefixSum[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

//Time Complexity: O(1)
//Space Complexity: O(n)