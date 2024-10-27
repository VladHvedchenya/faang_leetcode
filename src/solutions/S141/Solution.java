package solutions.S141;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode hair = head, tortoise = head;

        while (hair != null && hair.next != null){
            hair = hair.next.next;
            tortoise = tortoise.next;

            if (hair == tortoise)
                return true;
        }

        return false;
    }
}

//Time Complexity: O(1)
//Space Complexity: O(1)
