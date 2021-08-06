package linkedList;

/*
 * 단일 연결 리스트, 리스트를 reverse해서 리턴
 * input : [1,2,3]
 * output: [3,2,1] 
 */

class ListNode2 {
	int val;
	ListNode2 next;
	ListNode2(int x) {
		this.val = x;
	}
}

class ReverseLinkedList{
	public ListNode2 solve(ListNode2 cur) {
		
		// 1. DS
		ListNode2 next = null;
		ListNode2 prev = null;
		
		// 2. for while
		while(cur != null) {
			next = cur.next;	// 2, 3
			cur.next = prev;	// null
			prev = cur;			// 1
			cur = next;			// 2, 3
			
		}
		
		return prev;
	}
}

public class No03_ReverseLinkedList {
	public static void main(String[] args) {
		ListNode2 l1 = new ListNode2(1);
		l1.next = new ListNode2(2);
		l1.next.next = new ListNode2(3);
		ReverseLinkedList sol = new ReverseLinkedList();
		print(sol.solve(l1));
	}
	
	public static void print(ListNode2 node) {
		while(node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}
