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

        curr = head;

        while (!stack.isEmpty()) {
            ListNode temp = curr.next;
            ListNode fromStack = stack.pop();
            curr.next = fromStack;
            fromStack.next = temp;
            curr = temp;
        }
    }

    // Find middle, then reverse the second half, then merge the two lists.
    /*
     * public void reorderList(ListNode head) {
     * 
     * ListNode slow = head;
     * ListNode fast = head.next;
     * while(fast != null && fast.next != null) {
     * slow = slow.next;
     * fast = fast.next.next;
     * }
     * 
     * ListNode head2 = slow.next;
     * slow.next = null;
     * head2 = reverse(head2);
     * 
     * head = merge(head, head2);
     * }
     * 
     * private ListNode merge(ListNode head1, ListNode head2) {
     * ListNode curr1 = head1;
     * ListNode curr2 = head2;
     * 
     * while(curr1 != null && curr2 != null) {
     * ListNode next1 = curr1.next;
     * ListNode next2 = curr2.next;
     * 
     * curr1.next = curr2;
     * curr2.next = next1;
     * 
     * curr1 = next1;
     * curr2 = next2;
     * }
     * 
     * return head1;
     * }
     * 
     * private ListNode reverse(ListNode head) {
     * ListNode curr = head;
     * ListNode prev = null;
     * 
     * while(curr != null) {
     * ListNode next = curr.next;
     * curr.next = prev;
     * prev = curr;
     * curr = next;
     * }
     * 
     * return prev;
     * }
     */
}
// @lc code=end
