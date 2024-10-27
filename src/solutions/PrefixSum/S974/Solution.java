package solutions.PrefixSum.S974;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int prefixSum = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            int reminder = prefixSum % k;

            if (reminder < 0)
                reminder += k;

            if (map.containsKey(reminder))
                res += map.get(reminder);

            map.put(reminder, map.getOrDefault(reminder, 0) + 1);
        }

        return res;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)