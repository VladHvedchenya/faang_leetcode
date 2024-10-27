package solutions.PrefixSum.S724;

class Solution {
    public int pivotIndex(int[] nums) {
        int[] leftSum = new int[nums.length];
        leftSum[0] = nums[0];
        int[] rightSum = new int[nums.length];
        rightSum[rightSum.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < leftSum.length; i++){
            leftSum[i] = leftSum[i - 1] + nums[i];
        }

        for (int i = rightSum.length - 2; i >= 0; i--){
            rightSum[i] = rightSum[i + 1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++){
            if (leftSum[i] == rightSum[i])
                return i;
        }

        return -1;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)