package solutions.Others.PrefixSum.S560;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int prefixSum = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            int tempTarget = prefixSum - k;

            if (map.containsKey(tempTarget))
                res += map.get(tempTarget);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return res;
    }
}

//Time Complexity: O(n);
//Space Complexity: O(n);