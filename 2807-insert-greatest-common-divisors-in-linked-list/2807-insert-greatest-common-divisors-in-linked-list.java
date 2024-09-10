/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private int gcd(int a, int b){
        while(b > 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        ListNode previous = null;
        
        while(head != null){
            if(previous != null){
                current.next = new ListNode(gcd(previous.val, head.val));
                current = current.next;
            }
            
            current.next = head;
            previous = head;
            head = head.next;
            current = current.next;
            current.next = null;
        }
        
        return dummy.next;
    }
}