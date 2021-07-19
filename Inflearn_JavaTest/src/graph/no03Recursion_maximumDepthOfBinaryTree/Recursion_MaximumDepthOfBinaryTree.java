package graph.no03Recursion_maximumDepthOfBinaryTree;

class TreeNode {
	int val;
	TreeNode left, right;

	TreeNode(int x) {
		this.val = x;
	}
}

class Solution {
	public int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int leftMax = maxDepth(root.left);
		int rightMax = maxDepth(root.right);
		return Math.max(leftMax, rightMax) + 1;
	}
}

public class Recursion_MaximumDepthOfBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(8);
		root.left.left.left = new TreeNode(7);
		
		Solution s = new Solution();
		System.out.println(s.maxDepth(root));
	}
}
