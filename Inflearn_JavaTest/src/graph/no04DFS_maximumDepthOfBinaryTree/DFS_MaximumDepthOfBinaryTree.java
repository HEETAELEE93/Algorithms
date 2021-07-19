package graph.no04DFS_maximumDepthOfBinaryTree;

import java.util.Stack;

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
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Integer> valueStack = new Stack<Integer>();
		stack.push(root);
		valueStack.push(1);
		int max = 0;
		
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			int count = valueStack.pop();
			max = Math.max(max, count);
			
			if(node.left != null) {
				stack.push(node.left);
				valueStack.push(1+count);
			}
			if(node.right != null) {
				stack.push(node.right);
				valueStack.push(1+count);
			}
		}

		return max;
	}
}

// 틀림
class MySolution {
	public int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		Stack<TreeNode> st = new Stack<TreeNode>();
		int count = 1;
		
		st.push(root);
		while(!st.isEmpty()) {
			TreeNode node = st.pop();
			if(node.left != null || node.right != null) {
				if(node.left != null) {
					st.push(node.left);
				}
				if(node.right != null) {
					st.push(node.right);
				}
				count++;
			}
		}
		return count;
	}
}
public class DFS_MaximumDepthOfBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(6);
		
		Solution s = new Solution();
		System.out.println(s.maxDepth(root));
		
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.right.right = new TreeNode(31);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);
		root1.left.left.left = new TreeNode(6);
		
		MySolution ms = new MySolution();
		System.out.println(ms.maxDepth(root1));
	}

}
