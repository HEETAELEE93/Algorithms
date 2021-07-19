package MyLinkedList;

import MyLinkedList.MyLinkedList6.Node;

class MyLinkedList6 {
	Node header;

	static class Node {
		int data;
		Node next = null;
	}

	MyLinkedList6() {
		header = new Node();
	}

	void append(int d) {
		Node end = new Node();
		end.data = d;
		Node n = header;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	void delete(int d) {
		Node n = header;
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}

	void retrieve() {
		Node n = header.next;
		while (n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}

	void removeDups() {
		Node n = header;
		while (n != null && n.next != null) {
			Node r = n;
			while (r.next != null) {
				if (n.data == r.next.data) {
					r.next = r.next.next;
				} else {
					r = r.next;
				}
			}
			n = n.next;
		}
	}

	Node getfirst() {
		return header;
	}

	Node KthToLast(Node first, int k) {

		Node p1 = first;
		Node p2 = first;

		for (int i = 0; i < k; i++) {
			if (p1 == null) {
				return null;
			}
			p1 = p1.next;
		}
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}

	Node get(int n) {
		Node index = header;
		for (int i = 0; i <= n; i++) {
			index = index.next;
		}
		return index;
	}

	boolean deleteNode(Node n) {
		if (n == null || n.next == null) {
			return false;
		}
		Node next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}

	Node Partition(Node n, int x) {
		Node s1 = null;
		Node e1 = null;
		Node s2 = null;
		Node e2 = null;

		while (n != null) {
			Node next = n.next;
			n.next = null;
			if (n.data < x) {
				if (s1 == null) {
					s1 = n;
					e1 = s1;
				} else {
					e1.next = n;
					e1 = n;
				}
			} else {
				if (s2 == null) {
					s2 = n;
					e2 = s2;
				} else {
					e2.next = n;
					e2 = n;
				}
			}
			n = next;
		}
		if (s1 == null) {
			return s2;
		} else {
			e1.next = s2;
			return s1;
		}
	}
	
	Node Partition2(Node n, int x) {
		Node head = n;
		Node tail = n;
		
		while(n != null) {
			Node next = n.next;
			if(n.data < x) {
				n.next = head;
				head = n;
			} else {
				tail.next = n;
				tail = n;
			}
			n = next;
		}
		tail.next = null;
		return head;
	}
	
}

public class A6_KthDivide {
	public static void main(String[] args) {
		MyLinkedList6 ll = new MyLinkedList6();
		ll.append(7);
		ll.append(2);
		ll.append(8);
		ll.append(5);
		ll.append(3);
		ll.append(4);
		
		ll.retrieve();
		Node n = ll.Partition2(ll.get(0), 5);
		while (n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
		
	}
}
