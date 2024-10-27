package solutions.PrefixSum.S1480;

class Solution {
    public int[] runningSum(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for (int i = 1; i < prefixSum.length; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        return prefixSum;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution2 {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++){
            nums[i] = nums[i - 1] + nums[i];
        }

        return nums;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)