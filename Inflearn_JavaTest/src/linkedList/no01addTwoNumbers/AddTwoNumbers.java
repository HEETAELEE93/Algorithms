package linkedList.no01addTwoNumbers;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		this.val = x;
	}
}

class Solution {
	public ListNode solve(ListNode l1, ListNode l2) {
		ListNode newHead = new ListNode(0);
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode p3 = newHead;
		
		int carry = 0;
		
		while(p1 != null || p2 != null) {
			if(p1 != null) {
				carry += p1.val;
				p1 = p1.next;
			}
			if(p2 != null) {
				carry += p2.val;
				p2 = p2.next;
			}
			p3.next = new ListNode(carry % 10);
			p3 = p3.next;
			carry /= 10;
		}
		if(carry == 1) {
			p3.next = new ListNode(1);
		}
		
		return newHead.next;
	}
}

// 복사 안하면 마지막것만 가리키므로 왠만하면 복사해서 사용
class MySolution {
	public ListNode solve(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		
		int carry = 0;
		
		while(l1 != null || l2 != null) {
			if(l1 != null) {
				carry += l1.val;
				l1 = l1.next;
			}
			if(l2 != null) {
				carry += l2.val;
				l2 = l2.next;
			}
			head.next = new ListNode(carry % 10);
			head = head.next;
			carry /= 10;
		}
		
		if(carry == 1) {
			head.next = new ListNode(1);
		}
		
		return head;
	}
}

public class AddTwoNumbers {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(2);
		
		ListNode node = new Solution().solve(l1, l2);
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		System.out.println("---------");
		ListNode node2 = new MySolution().solve(l1, l2);
		while(node2 != null) {
			System.out.print(node2.val + " ");
			node2 = node2.next;
		}
		
	}
}
