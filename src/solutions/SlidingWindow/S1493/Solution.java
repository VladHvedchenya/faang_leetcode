package solutions.SlidingWindow.S1493;

class Solution {
    public int longestSubarray(int[] nums) {
        int deleteCount = 1;
        int left = 0, right = 0;

        for (right = 0; right < nums.length; right++){
            if (nums[right] == 0)
                deleteCount--;

            if (deleteCount < 0){
                if (nums[left] == 0)
                    deleteCount++;
                left++;
            }
        }

        return right - left - 1;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)