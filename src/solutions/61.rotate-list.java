package solutions;
/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null)
            return head;

        ListNode pointer = head;
        int size = 1;

        while (pointer.next != null) {
            size++;
            pointer = pointer.next;
        }

        k = k % size;
        pointer.next = head;

        pointer = head;

        for (int i = 0; i < size - k - 1; i++) {
            pointer = pointer.next;
        }

        ListNode answer = pointer.next;
        pointer.next = null;

        return answer;

    }
}
// @lc code=end
