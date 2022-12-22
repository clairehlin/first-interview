package com.first.interview.algorithm;
/*
https://leetcode.com/problems/add-two-numbers/
Initialize current node to dummy head of the returning list.
Initialize carry to 00.
Loop through lists l1 and l2 until you reach both ends and carry is 0.
Set x to node l1's value. If l1 has reached the end of l1, set to 0.
Set y to node l2's value. If l2 has reached the end of l2 set to 0.
Set sum = x + y + carry.
Update carry = sum / 10carry=sum/10.
Create a new node with the digit value of (sum \bmod 10)(summod10) and set it to current node's next, then advance current node to next.
Advance both l1l1 and l2l2.
Return dummy head's next node.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currentNode = new ListNode(0);
        ListNode res = currentNode;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return res.next;
    }
}
