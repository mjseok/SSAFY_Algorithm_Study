package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1991ss {
	static StringBuilder sb = new StringBuilder();
	static Node root = new Node('A', null, null);

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			String[] nodes = in.readLine().split(" ");
			char data = nodes[0].charAt(0);
			char leftData = nodes[1].charAt(0);
			char rightData = nodes[2].charAt(0);
			add(root, data, leftData, rightData);
		}
		preOrder(root);
		sb.append("\n");
		inOrder(root);
		sb.append("\n");
		postOrder(root);
		System.out.println(sb);
	}

	static class Node {
		char data;
		Node leftNode, rightNode;
		public Node(char data, Node leftNode, Node rightNode) {
			this.data = data;
		}
	}

	public static void add(Node tmp, char data, char leftData, char rightData) {
		if (tmp.data == data) {

			if (leftData != '.')
				tmp.leftNode = new Node(leftData, null, null);
			else {
				tmp.leftNode=null;
			}
			if (rightData != '.')
				tmp.rightNode = new Node(rightData, null, null);
			else {
				tmp.rightNode=null;
			}
		} else {

			if (tmp.leftNode != null)
				add(tmp.leftNode, data, leftData, rightData);
			if (tmp.rightNode != null)
				add(tmp.rightNode, data, leftData, rightData);
		}
	}

	// 전위순회
	public static void preOrder(Node node) {

		if (node == null)
			return;
		sb.append(node.data);
		if (node.leftNode != null)
			preOrder(node.leftNode);
		if (node.rightNode != null)
			preOrder(node.rightNode);
	}

	// 중위순회
	public static void inOrder(Node node) {
		if (node == null)
			return;
		if (node.leftNode != null)
			inOrder(node.leftNode);
		sb.append(node.data);
		if (node.rightNode != null)
			inOrder(node.rightNode);
	}

	// 후위순회
	public static void postOrder(Node node) {
		if (node == null)
			return;
		if (node.leftNode != null)
			postOrder(node.leftNode);
		if (node.rightNode != null)
			postOrder(node.rightNode);
		sb.append(node.data);
	}

}
