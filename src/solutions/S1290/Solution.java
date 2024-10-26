package solutions.S1290;

public class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode curr = head;
        int count = 0;
        int res = 0;

        while(curr != null){
            count++;
            curr = curr.next;
        }

        count--;
        curr = head;

        while(curr != null){
            res += (int) Math.pow(2, count--) * curr.val;
            curr = curr.next;
        }

        return res;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)