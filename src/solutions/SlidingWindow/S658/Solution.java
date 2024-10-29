package solutions.SlidingWindow.S658;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;

        while (left < right){
            int mid = (left + right) / 2;

            if (x - arr[mid] > arr[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }

        return Arrays.stream(arr, left, left + k).boxed().collect(Collectors.toList());
    }
}

/*Это жестко. Как по мне такая задача должна быть Hard, хоть в ней и не используется ничего углубленного, но
до этого додуматься очень тяжело самому. Засуньте решение в gpt и разберите, почему так оптимально.
 */
//Time Complexity: O(logn + k)
//Space Complexity: O(k)