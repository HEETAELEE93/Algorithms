package graph;

class TreeNodeMaxBinary {
	int val;
	TreeNodeMaxBinary left, right;
	TreeNodeMaxBinary(int x){
		this.val = x;
	}
}

class MaximumDepthOfBinaryTreeRecur{
	public int maxDepth(TreeNodeMaxBinary root) {
		
		if(root == null) {
			return 0;
		}
		int leftMax = maxDepth(root.left);
		int rightMax = maxDepth(root.right);
		
		return Math.max(leftMax, rightMax) + 1;
	}
}

public class No02_recursive_MaximumDepthOfBinaryTree {
	public static void main(String[] args) {
		TreeNodeMaxBinary tree = new TreeNodeMaxBinary(3);
		tree.left = new TreeNodeMaxBinary(1);
		tree.right = new TreeNodeMaxBinary(4);
		tree.left.left = new TreeNodeMaxBinary(5);
		tree.left.right = new TreeNodeMaxBinary(8);
		tree.left.left.left = new TreeNodeMaxBinary(7);
		MaximumDepthOfBinaryTreeRecur sol = new MaximumDepthOfBinaryTreeRecur();
		System.out.println(sol.maxDepth(tree));
	}
}
