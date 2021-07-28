package linkedList;

/*
 * K개의 정렬된 리스트 병합
 * input = {1,4,5} / {1,3,4}, {2,7}
 * output = {1,1,2,3,4,4,5,7}
 */
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class ListNode1 {
	int val;
	ListNode1 next;
	ListNode1() {
	}
	ListNode1(int val){
		this.val = val;
	}
	ListNode1(int val, ListNode1 next){
		this.val = val;
		this.next = next;
	}
}

class MergeKSortedLists{
	public ListNode1 solve(ListNode1[] lists) {
		
		// 1. Priority Queue 정렬 방법 3가지
		Queue<ListNode1> q = new PriorityQueue<ListNode1>((a,b) -> a.val - b.val);
		// 2.
		Queue<ListNode1> q2 = new PriorityQueue<ListNode1>(new Comparator<>() {
			@Override
			public int compare(ListNode1 o1, ListNode1 o2) {
				return o1.val - o2.val;
			}
		});
		// 3.
		Queue<ListNode1> q3 = new PriorityQueue<ListNode1>(Comp);
		
		
		ListNode1 head = new ListNode1(0);
		ListNode1 res = head;
		
		// for while
		for(ListNode1 list : lists) {
			if(list != null) {
				q.offer(list);
			}
		}
		while(!q.isEmpty()) {
			ListNode1 node = q.poll();
			res.next = node;
			res = res.next;
			
			if(node.next != null) {
				q.offer(node.next);
			}
		}
		return head.next;
	}
	
	Comparator<ListNode1> Comp =  new Comparator<>() {
		@Override
		public int compare(ListNode1 o1, ListNode1 o2) {
			return o1.val - o2.val;
		}
	};
}

public class No02_MergeKSortedLists {
	public static void main(String[] args) {
		ListNode1 l1 = new ListNode1(1);
		l1.next = new ListNode1(4);
		l1.next.next = new ListNode1(5);
		
		ListNode1 l2 = new ListNode1(1);
		l2.next = new ListNode1(3);
		l2.next.next = new ListNode1(4);
		
		ListNode1 l3 = new ListNode1(2);
		l3.next = new ListNode1(7);
		
		ListNode1[] list = new ListNode1[3];
		list[0] = l1;
		list[1] = l2;
		list[2] = l3;
		
		ListNode1 result = new MergeKSortedLists().solve(list);
		new No02_MergeKSortedLists().print(result);
	}
	
	private void print(ListNode1 node) {
		while(node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}
