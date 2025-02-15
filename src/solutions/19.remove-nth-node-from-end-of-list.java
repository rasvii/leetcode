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
        ListNode current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        current = head;

        n = count - n;
        if (n == 0)
            return head = head.next;

        count = 0;

        while (count < n) {
            if (count == n - 1) {
                current.next = current.next.next;
            }
            count++;
            current = current.next;
        }

        // if (current.next != null && current.next.next != null)
        // current.next = current.next.next;

        return head;

    }
}
// @lc code=end
