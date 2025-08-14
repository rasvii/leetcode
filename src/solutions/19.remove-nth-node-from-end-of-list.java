/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int count = 0;
        ListNode curr = head;

        while (curr != null) {
            curr = curr.next;
            count++;
        }

        int diff = count - n;

        if (diff == 0) {
            return head = head.next;
        }

        curr = head;
        count = 1;
        while (count < diff) {
            curr = curr.next;
            count++;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
        }

        return head;
    }
}
// @lc code=end
