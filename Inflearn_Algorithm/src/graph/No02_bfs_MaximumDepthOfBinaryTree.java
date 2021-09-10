package graph;

import java.util.LinkedList;
import java.util.Queue;

class MaximumDepthOfBinaryTreeBFS{
	public int maxDepth(TreeNodeMaxBinary root) {
		if(root == null) {
			return 0;
		}
		
		Queue<TreeNodeMaxBinary> que = new LinkedList<TreeNodeMaxBinary>();
		que.offer(root);
		int count = 0;
		
		while(!que.isEmpty()) {
			int size = que.size();
			for(int i = 0; i < size; i++) {
				TreeNodeMaxBinary node = que.poll();
				if(node.left != null) {
					que.offer(node.left);
				}
				if(node.right != null) {
					que.offer(node.right);
				}
			}
			count++;
		}
		
		return count;
	}
}

public class No02_bfs_MaximumDepthOfBinaryTree {
	public static void main(String[] args) {
		TreeNodeMaxBinary tree = new TreeNodeMaxBinary(3);
		tree.left = new TreeNodeMaxBinary(1);
		tree.right = new TreeNodeMaxBinary(4);
		tree.left.left = new TreeNodeMaxBinary(5);
		tree.left.right = new TreeNodeMaxBinary(8);
		tree.left.left.left = new TreeNodeMaxBinary(7);
		MaximumDepthOfBinaryTreeBFS sol = new MaximumDepthOfBinaryTreeBFS();
		System.out.println(sol.maxDepth(tree));
	}
}
