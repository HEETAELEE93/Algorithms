package linkedList;

/*
 * Add Two Numbers
 * input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * output: 7 -> 0 -> 8
 * explanation: 342 + 465 => 807
 */

class ListNode {
	int val;
	ListNode next;
	public ListNode(int x) {
		this.val = x;
	}
}

class AddTwoNumbers {
	public ListNode solve(ListNode l1, ListNode l2) {
		ListNode newHead = new ListNode(0);
		ListNode p1 = l1, p2 = l2, p3 = newHead;	// 데이터 조작이 일어나기 때문에 카피
		int carry = 0;	// 6 + 4
		
		while( p1 != null || p2 != null ) {
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

public class No01_AddTwoNumbers {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(2);
		
		ListNode node = new AddTwoNumbers().solve(l1, l2);
		while(node != null) {
			System.out.print(node.val);
			node = node.next;
		}
	}
}
