package MyLinkedList;

class MyLinkedList{
	Node header;
	
	static class Node{
		int data;
		Node next = null;
	}
	
	MyLinkedList(){
		header = new Node();
	}
	
	void append(int d) {
		Node end = new Node();
		end.data = d;
		Node n = header;
		while(n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	void delete(int d) {
		Node n = header;
		while(n.next != null) {
			if(n.next.data == d) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}
	
	void retrieve() {
		Node n = header.next;
		while(n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}
}


public class A2_MyLinkedListEx {
	public static void main(String[] args) {
		MyLinkedList1 mll = new MyLinkedList1();
		mll.append(1);
		mll.append(2);
		mll.append(3);
		mll.append(4);
		mll.retrieve();
		mll.delete(1);
		mll.retrieve();
	}

}
