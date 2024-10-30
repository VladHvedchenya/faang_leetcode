package solutions.SlidingWindow.S2024;

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int ans = 0, leftT = 0, leftF = 0, countT = k, countF = k;

        for (int right = 0; right < answerKey.length(); right++){
            if (answerKey.charAt(right) == 'T')
                countF--;
            else
                countT--;

            if (countF < 0){
                if (answerKey.charAt(leftF) == 'T'){
                    countF++;
                }
                leftF++;
            }

            if (countT < 0){
                if (answerKey.charAt(leftT) == 'F'){
                    countT++;
                }
                leftT++;
            }

            ans = Math.max(ans, Math.max(right - leftT + 1, right - leftF + 1));
        }

        return ans;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)