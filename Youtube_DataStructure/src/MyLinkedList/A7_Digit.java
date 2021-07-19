package MyLinkedList;

import MyLinkedList.MyLinkedList7.Node;

class MyLinkedList7 {
	static class Node {
		int data;
		Node next = null;
	}

	Node header;

	MyLinkedList7() {
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

	Node partition(Node n, int x) {
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

	Node partition2(Node n, int x) {
		Node head = n;
		Node tail = n;

		while (n != null) {
			Node next = n.next;
			if (n.data < x) {
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

	Node sumLists(Node l1, Node l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}

		Node result = new Node();

		int value = carry;

		if (l1 != null) {
			value += l1.data;
		}
		if (l2 != null) {
			value += l2.data;
		}
		result.data = value % 10;

		if (l1 != null || l2 != null) {
			Node next = sumLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
			result.next = next;
		}
		return result;
	}
	Node iMadesumList(Node l1, Node l2, int carry) {
		if(l1 == null && l2 == null && carry == 0) {
			return null;
		}
		Node result = new Node();
		int value = carry;
		int carr = 0;
		
		if(l1 != null) {
			value += l1.data;
		}
		if(l2 != null) {
			value += l2.data;
		}
		if(value >= 10) {
			carr = value / 10;
		}
		result.data = value % 10;
		if(l1 != null || l2 != null) {
			Node next = iMadesumList(l1 == null ? null : l1.next, l2 == null ? null : l2.next , carr);
			result.next = next;
		}
		return result;
	}
	
	
	

}

public class A7_Digit {
	public static void main(String[] args) {
		MyLinkedList7 l1 = new MyLinkedList7();
		l1.append(9);
		l1.append(1);
		l1.append(4);
		l1.retrieve();

		MyLinkedList7 l2 = new MyLinkedList7();
		l2.append(6);
		l2.append(4);
		l2.append(3);
		l2.retrieve();

		MyLinkedList7 l3 = new MyLinkedList7();
		Node n = l3.sumLists(l1.get(0), l2.get(0), 0);
		
		while(n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}
}
