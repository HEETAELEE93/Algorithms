package no7_recursiveTreeGraph;

import java.util.LinkedList;
import java.util.Queue;

class Nodebfs {
	int data;
	Nodebfs lt, rt;

	public Nodebfs(int val) {
		data = val;
		lt = rt = null;
	}
}

class BinaryTreeSearchBFS {
	Nodebfs root;

	public void bfs(Nodebfs root) {
		Queue<Nodebfs> que = new LinkedList<Nodebfs>();
		
		que.offer(root);
		int L = 0;

		while(!que.isEmpty()) {
			int len = que.size();
			System.out.print("level: " + L + " | ");
			
			for(int i = 0; i < len; i++) {
				Nodebfs cur = que.poll();
				System.out.print(cur.data + " ");
				
				if(cur.lt != null) {
					que.offer(cur.lt);
				}
				if(cur.rt != null) {
					que.offer(cur.rt);
				}
			}
			L++;
			System.out.println();
		}
	}
}

public class N07_BinaryTreeSearch_bfs {
	public static void main(String[] args) {
		BinaryTreeSearchBFS tree = new BinaryTreeSearchBFS();
		tree.root = new Nodebfs(1);
		tree.root.lt = new Nodebfs(2);
		tree.root.rt = new Nodebfs(3);
		
		tree.root.lt.lt = new Nodebfs(4);
		tree.root.lt.rt = new Nodebfs(5);
		
		tree.root.rt.lt = new Nodebfs(6);
		tree.root.rt.rt = new Nodebfs(7);
		
		tree.bfs(tree.root);
	}
}