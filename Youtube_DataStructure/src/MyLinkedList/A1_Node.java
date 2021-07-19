package MyLinkedList;

class A1_Node {

	int data;
	A1_Node next = null;
	
	A1_Node(int data) {
		this.data = data;
	}
	
	void append(int d) {
		A1_Node end = new A1_Node(d);
		A1_Node n = this;
		while(n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	void delete(int d) {
		A1_Node n = this;
		while(n.next != null) {
			if(n.next.data == d) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}
	
	void retrieve() {
		A1_Node n = this;
		while(n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}
	
	public static void main(String[] args) {
		A1_Node head = new A1_Node(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.retrieve();
		head.delete(3);
		head.retrieve();
	}
}
