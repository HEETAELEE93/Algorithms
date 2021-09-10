package graph;

import java.util.Stack;

class MaximumDepthOfBinaryTreeDFS{
	public int maxDepth(TreeNodeMaxBinary root) {
		
		if(root == null) {
			return 0;
		}
		
		Stack<TreeNodeMaxBinary> stack = new Stack<>();
		Stack<Integer> valueStack = new Stack<Integer>();
		
		stack.push(root);
		valueStack.push(1);
		
		int max = 0;
		
		while(!stack.isEmpty()) {
			TreeNodeMaxBinary node = stack.pop();
			int count = valueStack.pop();
			max = Math.max(max, count);
			
			if(node.left != null) {
				stack.push(node.left);
				valueStack.push(1 + count);
			}
			if(node.right != null) {
				stack.push(node.right);
				valueStack.push(1 + count);
			}
			
		}
		
		return max;
	}
}

public class No02_dfs_MaximumDepthOfBinaryTree {
	public static void main(String[] args) {
		TreeNodeMaxBinary tree = new TreeNodeMaxBinary(3);
		tree.left = new TreeNodeMaxBinary(1);
		tree.right = new TreeNodeMaxBinary(4);
		tree.left.left = new TreeNodeMaxBinary(5);
		tree.left.right = new TreeNodeMaxBinary(8);
		tree.left.left.left = new TreeNodeMaxBinary(7);
		MaximumDepthOfBinaryTreeDFS sol = new MaximumDepthOfBinaryTreeDFS();
		System.out.println(sol.maxDepth(tree));
	}
}
