package solutions.PrefixSum.S2389;

import java.util.Arrays;

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] prefixSum = new int[nums.length + 1];
        int[] answers = new int[queries.length];

        for (int i = 1; i < prefixSum.length; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < queries.length; i++){
            answers[i] = binarySearch(queries[i], prefixSum);
        }

        return answers;
    }

    public int binarySearch(int sum, int[] prefixSum){
        int left = 0, right = prefixSum.length - 1, mid, answer = 0;

        while (left <= right){
            mid = (left + right) / 2;

            if (prefixSum[mid] <= sum){
                answer = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return answer;
    }
}


//Time Complexity: O(nlogn + mlogn);
//Space Complexity: O(max(n, m));
/*Подробное объяснение о Time Complexity:
    * - Изначальная сортировка массива nums размером n -> nlogn
    * - Дальше следующий цикл идет отдельно, а значит используем знак "+"
    * - Заполнить массив префиксных сумм -> O(n + 1) -> O(n) | n + 1, потому что длина префиксных сумм с учетом нуля идет,
        а значит на 1 элемент больше надо хранить
    * - Пусть длина queries равна m, тогда для каждого элемента этого массива мы вызываем бинарный поиск.
        Бинарный поиск работает за logn, а значит общая скорость будет mlogn. Почему logn, а не logm?
        Потому что бинарный поиск выполняется по массиву префиксных сумм, а мы до этого оговорили, что скорость
        выполнения по нему равна O(n).
    * - Общая сложность получается следующая: O(nlogn) + O(n) + O(mlogn).
    * - Так как мы имеем две сложности по ОБЩЕЙ переменной n, то это значит, что мы можем сократить их. По какому принципу?
    * Все просто! Выбирается худшая из них. Худшая среди O(nlogn) и O(n) - это O(nlogn), а значит общая сложность:
    * O(nlogn) + O(mlogn) -> O(nlogn + mlogn)
 */
/*Подробное объяснение о Space Complexity:
    * - Здесь все проще. Мы создаем массив префиксных сумм, который зависит от длины nums, то есть от n. Создаем размером
    * n + 1, а значит по памяти это стоит O(n + 1)
    * - И мы создаем массив ответов, зависящий от queries, т.е. от m, создаем такого же размера, а значит это O(m)
    * - Таким образом имеет O(n + 1) и O(m). Но ответ-то какой? А нужно понять, какой из этих массивов длиннее.
    * В данном случае, если разобраться в условии, то как первый может быть длиннее, так и второй, а значит берем худший
    * случай, а это max(n+1, m). Избавляемся от констант и имеем ответ: O(max(n, m))
 */