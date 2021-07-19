package graph.no05BFS_maximumDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left, right;

	TreeNode(int x) {
		this.val = x;
	}
}

class Solution {
	public int BFS_maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.offer(root);
		int count = 0;
		
		while(!que.isEmpty()) {
			int size = que.size();
			count++;
			for(int i = 0; i < size; i++) {
				TreeNode node = que.poll();
				
				if(node.left != null) {
					que.offer(node.left);
				}
				if(node.right != null) {
					que.offer(node.right);
				}
			}
		}
		
		return count;
	}
}


public class BFS_MaximumDepthOfBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(6);
		
		Solution s = new Solution();
		System.out.println(s.BFS_maxDepth(root));
	}
}
