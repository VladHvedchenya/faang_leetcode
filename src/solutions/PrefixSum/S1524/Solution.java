package solutions.PrefixSum.S1524;

class Solution {
    public int numOfSubarrays(int[] arr) {
        int count = 0, odd = 0, even = 1, prefixSum = 0;
        int mod = 1_000_000_007;

        for (int num : arr){
            prefixSum += num;

            if (prefixSum % 2 == 0){
                count = (count + odd) % mod;
                even++;
            }
            else{
                count = (count + even) % mod;
                odd++;
            }
        }

        return count;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)