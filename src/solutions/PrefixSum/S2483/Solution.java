package solutions.PrefixSum.S2483;

public class Solution {
    public int bestClosingTime(String customers) {
         int[] prefixSum = new int[customers.length() + 1];
         int max = 0, res = 0;

         for (int i = 1; i < prefixSum.length; i++){
             int curr = customers.charAt(i - 1) == 'Y' ? 1 : -1;
             prefixSum[i] = prefixSum[i - 1] + curr;

             if (prefixSum[i] > max){
                 max = prefixSum[i];
                 res = i;
             }
         }

         return res;
    }
}

//Time Complexity: O(n);
//Space Complexity: O(n);

class Solution2 {
    public int bestClosingTime(String customers) {
        int sum = 0, max = 0, res = 0;

        for (int i = 0; i < customers.length(); i++){
            sum += customers.charAt(i) == 'Y' ? 1 : -1;

            if (sum > max){
                max = sum;
                res = i + 1;
            }
        }

        return res;
    }
}

//Time Complexity: O(n);
//Space Complexity: O(1);