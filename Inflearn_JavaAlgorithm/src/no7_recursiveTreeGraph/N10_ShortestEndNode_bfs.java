package no7_recursiveTreeGraph;

import java.util.LinkedList;
import java.util.Queue;

class NodeN10 {
	int data;
	NodeN10 lt, rt;

	public NodeN10(int val) {
		data = val;
		lt = rt = null;
	}
}

class ShortestEndNodeBfs {
	NodeN10 root;

	public int bfs(int L, NodeN10 root) {
		Queue<NodeN10> que = new LinkedList<>();

		que.offer(root);
		while (!que.isEmpty()) {
			int len = que.size();
			for (int i = 0; i < len; i++) {
				NodeN10 tmp = que.poll();
				if (tmp.lt == null && tmp.rt == null) {
					return L;
				}
				que.offer(tmp.lt);
				que.offer(tmp.rt);
			}
			L++;
		}
		return L;
	}

	public int bfs2(NodeN10 root) {
		Queue<NodeN10> que = new LinkedList<>();

		que.offer(root);
		int L = 0;
		while (!que.isEmpty()) {
			int len = que.size();
			for (int i = 0; i < len; i++) {
				NodeN10 cur = que.poll();
				if (cur.lt == null && cur.rt == null) {
					return L;
				}
				if (cur.lt != null) {
					que.offer(cur.lt);
				}
				if (cur.rt != null) {
					que.offer(cur.rt);
				}
			}
			L++;
		}
		return 0;
	}
}

public class N10_ShortestEndNode_bfs {
	public static void main(String[] args) {
		ShortestEndNodeBfs tree = new ShortestEndNodeBfs();
		tree.root = new NodeN10(1);
		tree.root.lt = new NodeN10(2);
		tree.root.rt = new NodeN10(3);

		tree.root.lt.lt = new NodeN10(4);
		tree.root.lt.rt = new NodeN10(5);

		System.out.println(tree.bfs(0, tree.root));
		System.out.println(tree.bfs2(tree.root));
	}
}
