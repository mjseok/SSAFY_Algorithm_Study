package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_1991 {
	static StringBuilder sb = new StringBuilder();

	static class Node {
		char left;
		char right;

		public Node(char left, char right) {
			this.left = left;
			this.right = right;
		}
	}

	static Map<Character,Node> tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine());

		tree = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String[] nodes = in.readLine().split(" ");
			char data = nodes[0].charAt(0);
			char left = nodes[1].charAt(0);
			char right = nodes[2].charAt(0);
			Node node = new Node(left, right);
			tree.put(data,node);
		}
		preorder('A');
		sb.append("\n");
		inorder('A');
		sb.append("\n");
		postorder('A');
		sb.append("\n");
	}
	//전위순회
	private static void preorder(char start) {
		System.out.println(tree.get(start));
		for(Node node: tree.get(start)) {
			
		}
	}
	//중위순회
	private static void inorder(char start) {

	}
	//후위순회
	private static void postorder(char start) {
		
	}
}
