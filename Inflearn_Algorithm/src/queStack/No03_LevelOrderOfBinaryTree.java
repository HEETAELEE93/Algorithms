package queStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 이진 트리가 주어지면 노드 값의 레벨 순서 순회를 반환
 * output: [[1], [2,3], [4,5]]
 */

class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode(int x) {
		this.val = x;
	}
}

class LevelOrderOfBinaryTree{
	public List<List<Integer>> solve(TreeNode root) {
		// 1. DS
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		
		que.offer(root);
		
		// 2. for, while, add Algorithm
		while(!que.isEmpty()) {
			int size = que.size();
			List<Integer> list = new ArrayList<Integer>();
			
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

public class No03_LevelOrderOfBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		LevelOrderOfBinaryTree sol = new LevelOrderOfBinaryTree();
		System.out.println(sol.solve(root));
	}
}
