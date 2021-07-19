package linkedList.no03reverseLinkedLists;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		this.val = x;
	}
}

class Solution {
	public ListNode reverseList(ListNode current) {
		ListNode next = null;
		ListNode prev = null;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		return prev;
	}
	public void printNode(ListNode head) {
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}

public class ReverseLinkedLists {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		
		new Solution().printNode(l1);
		System.out.println();
		ListNode head = new Solution().reverseList(l1);
		new Solution().printNode(head);
	}
}
