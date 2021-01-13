package leet.linked_list_cycle;

// https://leetcode.com/problems/linked-list-cycle/

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slowRunner = head;
        ListNode fastRunner = head;
        while (slowRunner.next != null && fastRunner.next != null && fastRunner.next.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
            if (fastRunner == slowRunner) {
                return true;
            }
        }
        return false;
    }
}
