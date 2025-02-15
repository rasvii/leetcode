package solutions;
/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
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
    public ListNode reverseList(ListNode head) {

        if (head == null)
            return head;
        if (head.next == null) {
            return head;
        }

        ListNode pointer = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = pointer;
            pointer = head;
            head = next;
        }

        return pointer;

    }
}
// @lc code=end
