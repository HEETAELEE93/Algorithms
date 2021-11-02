package no7_recursiveTreeGraph;

class NodeN09 {
	int data;
	NodeN09 lt, rt;

	public NodeN09(int val) {
		data = val;
		lt = rt = null;
	}
}

class ShortestEndNodeDfs {
	NodeN09 root;
	public int dfs(int L, NodeN09 root) {
		if(root.lt == null && root.rt == null) {
			return L;
		}
		return Math.min(dfs(L+1, root.lt), dfs(L+1, root.rt));
	}
}

public class N09_ShortestEndNode_dfs {
	public static void main(String[] args) {
		ShortestEndNodeDfs tree = new ShortestEndNodeDfs();
		tree.root = new NodeN09(1);
		tree.root.lt = new NodeN09(2);
		tree.root.rt = new NodeN09(3);
		
		tree.root.lt.lt = new NodeN09(4);
		tree.root.lt.rt = new NodeN09(5);
		
		System.out.println(tree.dfs(0, tree.root));
	}
}
