package queueStack.no03binaryTreeLevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left, right;

	TreeNode(int x) {
		this.val = x;
	}
}

class Solution {
	public List<List<Integer>> solve(TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(root == null) {
			return result;
		}
		
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.offer(root);
		
		while(!que.isEmpty()) {
			int size = que.size();
			List<Integer> list = new LinkedList<Integer>();
			
			for(int i = 0; i < size; i++) {
				TreeNode node = que.poll();
				list.add(node.val);
				if(node.left != null) {
					que.offer(node.left);
				}
				if(node.right != null) {
					que.offer(node.right);
				}
			}
			
			result.add(list);
		}
		return result;
	}
}

class MySolution {
	public List<List<Integer>> solve(TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(root == null) {
			return result;
		}
		
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.offer(root);
		
		while(!que.isEmpty()) {
			int size = que.size();
			List<Integer> list = new LinkedList<Integer>();
			for(int i = 0; i < size; i++) {
				TreeNode node = que.poll();
				list.add(node.val);
				if(node.left != null) {
					que.offer(node.left);
				}
				if(node.right != null) {
					que.offer(node.right);
				}
			}
			result.add(list);
		}
		
		return result;
	}
}

public class BinaryTreeLevelOrder {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(7);
		
		Solution s = new Solution();
		System.out.println(s.solve(root));
		
		MySolution ms = new MySolution();
		System.out.println(ms.solve(root));
	}
}
