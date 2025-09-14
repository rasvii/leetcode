package solutions;
/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start

import java.util.*;

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
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;

        while (lists.length > 1) {
            List<ListNode> tmp = new ArrayList<>();
            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = i + 1 < lists.length ? lists[i + 1] : null;
                tmp.add(merge(l1, l2));
            }

            lists = tmp.toArray(new ListNode[0]);
        }

        return lists[0];
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode head = node;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }

            node = node.next;
        }

        node.next = l1 != null ? l1 : l2;

        return head.next;
    }
}
// @lc code=end
