package solutions;
/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 */

// @lc code=start

import java.util.Stack;

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
    public void reorderList(ListNode head) {

        int len = 0;
        ListNode curr = head;

        while (curr != null) {
            len++;
            curr = curr.next;
        }

        System.out.println("len = " + len);

        if (len <= 2) {
            return;
        }

        int mid = (len % 2 == 0) ? len / 2 : len / 2 + 1;

        System.out.println("mid = " + mid);

        Stack<ListNode> stack = new Stack<>();
        curr = head;
        int count = 1;
        ListNode prev = null; // to break the list

        while (curr != null) {
            if (count > mid) {
                stack.push(curr);
            }
            if (count == mid) {
                prev = curr; // last node of first half
            }
            count++;
            curr = curr.next;
        }

        System.out.println("stack size = " + stack.size());

        // Break the link to avoid cycles
        if (prev != null) {
            prev.next = null;
        }

        ListNode dummy = head;
        curr = head;

        while (!stack.isEmpty()) {
            ListNode temp = curr.next;
            ListNode fromStack = stack.pop();
            curr.next = fromStack;
            fromStack.next = temp;
            curr = temp;
        }
    }
}
// @lc code=end
