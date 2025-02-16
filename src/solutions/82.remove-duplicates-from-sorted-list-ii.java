/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null)
            return head;

        if (head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        while (current != null && current.next != null) {

            if (current.val == current.next.val) {

                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }

                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }

            } else {
                prev = current;
            }

            current = current.next;

        }

        return head;

    }
}
// @lc code=end
