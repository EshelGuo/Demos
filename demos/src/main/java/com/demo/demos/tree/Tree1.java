package com.demo.demos.tree;

import java.util.Arrays;
import java.util.Random;

/**
 * <br>createBy G
 * <br>createTime: 2021/6/8 10:32
 * <br>desc:平衡二叉树
 */
public class Tree1 {

	public static void main(String args[]){
		//12 11 10 9 8 7 6
		Tree tree = new Tree();
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			tree.add(random.nextInt(100));
		}

		System.out.println(tree.height);
		System.out.println(tree.toString());
	}

	public static class Tree {

		int height;
		Node root;

		public void add(int value) {
			Node node = new Node(value);
			if(root == null){
				root = node;
				root.deep = 1;
				return;
			}

			root.insert(node);

		}

		@Override
		public String toString() {
			int width = 2 << height - 1;
			int[][] array = new int[height][width];
			for (int[] line : array) {
				Arrays.fill(line, -1);
			}

			if(root != null){
				int index = root.saveRoot(array);
				root.saveLeft(array, index);
				root.saveRight(array, index);
			}

			StringBuilder sb = new StringBuilder();

			for (int[] line : array) {
				for (int value : line) {
					if(value == -1){
						sb.append("  ");
						continue;
					}

					if(value < 10){
						sb.append(" ");
					}
					sb.append(value);
				}
				sb.append('\n');
			}
			return sb.toString();
		}

		public class Node {
		int value;
		int deep;

		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		}

		void setDeep(int parentDeep){
			deep = parentDeep + 1;

			if(height < deep){
				height = deep;
			}

			if(left != null){
				left.setDeep(deep);
			}

			if(right != null){
				right.setDeep(deep);
			}
		}

		public int insert(Node node) {
			if(node.value > value){
				return insertRight(node);
			}else {
				return insertLeft(node);
			}
		}

		private int insertLeft(Node node) {
			if(left == null){
				node.setDeep(deep);
				left = node;
				return left.deep;
			}

			if(node.value > left.value){
				node.deep = left.deep;
				Node left = this.left;
				this.left = node;
				return node.insert(left);
			}else {
				return left.insert(node);
			}
		}

		private int insertRight(Node node) {
			if(right == null){
				node.setDeep(deep);
				right = node;
				return right.deep;
			}

			if(node.value < right.value){
				node.deep = right.deep;
				Node right = this.right;
				this.right = node;
				return node.insert(right);
			}else {
				return right.insert(node);
			}
		}

			public int saveRoot(int[][] array) {
				int[] target = array[deep - 1];
				int index = target.length / 2 + 1;
				target[index] = value;
				return index;
			}

			public void saveLeft(int[][] array, int parentIndex) {
				if(left == null) return;

				int[] target = array[left.deep - 1];

				int index = parentIndex - 2;

				target[index] = left.value;

				left.saveLeft(array, index);
				left.saveRight(array, index);
			}

			private void saveRight(int[][] array, int parentIndex) {
				if(right == null) return;

				int[] target = array[right.deep - 1];

				int index = parentIndex + 2;

				target[index] = right.value;

				right.saveLeft(array, index);
				right.saveRight(array, index);
			}
		}
	}
}