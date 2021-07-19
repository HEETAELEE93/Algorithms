package linkedList.no02mergeKSortedLists;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class ListNode {
	int val;
	ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
}

class Solution {
	public ListNode solve(ListNode[] list) {
		double start = System.nanoTime();
		Queue<ListNode> que = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		ListNode newHead = new ListNode(0);
		ListNode p = newHead;
		
		for(ListNode node : list) {
			if(node != null) {
				que.offer(node);
			}
		}
		
		while(!que.isEmpty()) {
			ListNode node = que.poll();
			p.next = node;
			p = p.next;
			if(node.next != null) {
				que.offer(node.next);
			}
		}
		double end = System.nanoTime();
		System.out.println("실행 시간 : " + ( end - start ) / 1000.0);
		return newHead.next;
	}
}

class MySolution {
	public ListNode solve(ListNode[] list) {
		double start = System.nanoTime();
		ListNode head = new ListNode(0);
		ListNode p = head;
		
		ListNode p1 = list[0];
		ListNode p2 = list[1];
		ListNode p3 = list[2];
		
		while(p1 != null || p2 != null || p3 != null) {
			int min = 0;
			if(p1 != null && p2 != null && p3 != null) {
				min = Math.min(p1.val, Math.min(p2.val, p3.val));
			} else if(p1 == null && p2 == null) {
				p.next = p3;
				break;
			} else if(p1 == null && p3 == null) {
				p.next = p2;
				break;
			} else if(p2 == null && p3 == null) {
				p.next = p1;
				break;
			}
			else if(p1 == null) {
				min = Math.min(p2.val, p3.val);
			} else if(p2 == null) {
				min = Math.min(p1.val, p3.val);
			} else if(p3 == null) {
				min = Math.min(p1.val, p2.val);
			}
			
			if(min == p1.val) {
				p.next = p1;
				p1 = p1.next;
			} else if(min == p2.val) {
				p.next = p2;
				p2 = p2.next;
			} else if(min == p3.val) {
				p.next = p3;
				p3 = p3.next;
			}
			p = p.next;
		}
		double end = System.nanoTime();
		System.out.println("실행 시간 : " + ( end - start ) / 1000.0);
		return head.next;
	}
}

class MySolution1{
	public ListNode solve(ListNode[] list) {
		double start = System.nanoTime();
		ListNode head = new ListNode(0);
		ListNode p = head;
		
		List<Integer> ll = new LinkedList<Integer>();
		
		for(ListNode node : list) {
			while(node != null) {
				ll.add(node.val);
				node = node.next;
			}
		}
		
		Collections.sort(ll, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		
		for(int i = 0; i < ll.size(); i++) {
			p.next = new ListNode(ll.get(i));
			p = p.next;
		}
		
		double end = System.nanoTime();
		System.out.println("실행 시간 : " + ( end - start ) / 1000.0);
		
		return head.next;
	}
}

public class MergeKSortedLists {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);
		
		ListNode[] list = new ListNode[3];
		list[0] = l1;
		list[1] = l2;
		list[2] = l3;
		
		ListNode node = new Solution().solve(list);
		//System.out.println(node);
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		System.out.println("==========");
		
		
		ListNode ll1 = new ListNode(1);
		ll1.next = new ListNode(4);
		ll1.next.next = new ListNode(5);
		
		ListNode ll2 = new ListNode(1);
		ll2.next = new ListNode(3);
		ll2.next.next = new ListNode(4);
		
		ListNode ll3 = new ListNode(2);
		ll3.next = new ListNode(6);
		
		ListNode[] list1 = new ListNode[3];
		list1[0] = ll1;
		list1[1] = ll2;
		list1[2] = ll3;
		
		ListNode myNode = new MySolution().solve(list1);
		while(myNode != null) {
			System.out.print(myNode.val + " ");
			myNode = myNode.next;
		}
		
		System.out.println();
		System.out.println("===========");
		
		ListNode lll1 = new ListNode(1);
		lll1.next = new ListNode(4);
		lll1.next.next = new ListNode(5);
		
		ListNode lll2 = new ListNode(1);
		lll2.next = new ListNode(3);
		lll2.next.next = new ListNode(4);
		
		ListNode lll3 = new ListNode(2);
		lll3.next = new ListNode(6);
		
		ListNode[] list2 = new ListNode[3];
		list2[0] = lll1;
		list2[1] = lll2;
		list2[2] = lll3;
		
		ListNode myNode1 = new MySolution1().solve(list2);
		while(myNode1 != null) {
			System.out.print(myNode1.val + " ");
			myNode1 = myNode1.next;
		}
	}
}
