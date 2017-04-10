package saima.jinritoutiao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BuildBinaryTree {

	static int[] left;
	static int[] in;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			left = new int[n];
			for (int i = 0; i < n; i++) {
				left[i] = sc.nextInt();
			}
			in = new int[n];
			for (int i = 0; i < n; i++) {
				in[i] = sc.nextInt();
			}
			
			Node root = reBuildTree(0, n-1, 0, n-1);
			if (root!=null) {
				Queue<Node> queue = new LinkedList<>();
				queue.offer(root);
				while (!queue.isEmpty()) {
					Node node = queue.peek();
					System.out.print(node.data+" ");
					if (node.lChild!=null) {
						queue.offer(node.lChild);
					}
					if (node.rChild!=null) {
						queue.offer(node.rChild);
					}
					queue.remove();
				}
			}
			
			System.out.println();
		left = null;
		in = null;
		}
	}
	private static Node reBuildTree(int startLeft, int endLeft, int startIn, int endIn){
		if (startLeft>endLeft||startIn>endIn||endLeft<0||endIn<0) {
			return null;
		}
		Node root = new Node(left[startLeft]);
		if (startLeft==endLeft&&startIn==endIn) {
			return root;
		}
		
		int inLoc = 0;
		for (int i = startIn; i <= endIn; i++) {
			if (left[startLeft]==in[i]) {
				inLoc = i;
				break;
			}
		}
		root.lChild = reBuildTree(startLeft+1, inLoc-startIn+startLeft, startIn, inLoc-1);
		root.rChild = reBuildTree(inLoc-startIn+startLeft+1, endLeft, inLoc+1, endIn);
		return root;
	}
}

class Node {
	int data;
	Node lChild;
	Node rChild;
	public Node(int data) {
		super();
		this.data = data;
		this.lChild = null;
		this.rChild = null;
	}
}
