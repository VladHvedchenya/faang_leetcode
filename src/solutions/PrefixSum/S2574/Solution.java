package solutions.PrefixSum.S2574;

public class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        int[] ans = new int[nums.length];

        for (int i = 1; i < leftSum.length; i++){
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }

        for (int i = rightSum.length - 2; i >= 0; i--){
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < ans.length; i++){
            ans[i] = Math.abs(rightSum[i] - leftSum[i]);
        }

        return ans;
    }
}

//Time Complexity: O(n);
//Space Complexity: O(n);