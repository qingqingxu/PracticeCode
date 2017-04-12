package saima.xiaomi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TreeHigh {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			if (n==1) {
				System.out.println(1);
				continue;
			}
			List<Pair> pairs = new ArrayList<>();
			for(int i=0; i< n-1;i++ ) {
				Pair pair = new Pair(sc.nextInt(), sc.nextInt());
				pairs.add(pair);
			}
			Collections.sort(pairs);
			TreeNode root = new TreeNode();
			root = root.createTree(pairs);
			//root.display(root);
			System.out.println(root.getHigh(root));
		}
	}

}

class Pair implements Comparable<Pair>{
	int parent;
	int child;
	public Pair(int parent, int child) {
		this.parent = parent;
		this.child = child;
	}
	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		if (parent == o.parent) {
			return child - o.child;
		}
		return parent - o.parent;
	}
	
}

class TreeNode{
	int code;
	TreeNode lChild;
	TreeNode rChild;
	public TreeNode(int code) {
		this.code = code;
		lChild = null;
		rChild = null;
	}
	
	
	public TreeNode() {
	}


	public TreeNode createTree(List<Pair> pairs){
		if (pairs==null) {
			return null;
		}
		
		TreeNode root = null;
		for (Pair pair : pairs) {
			root = insertNode(root, pair);
		}
		return root;
	}
	
	private TreeNode insertNode(TreeNode root, Pair pair){
		if (root==null) {
			root = new TreeNode(pair.parent);
			root.lChild = new TreeNode(pair.child);
			return root;
		}else{
			if (root.code==pair.parent) {
				
				TreeNode node = new TreeNode(pair.child);
				if (root.lChild==null) {
					root.lChild = node;
				}else {
					root.rChild = node;
				}
				return root;
			}
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			while(!queue.isEmpty()){
				TreeNode node = queue.peek();
				if (node.code == pair.parent) {
					TreeNode child = new TreeNode(pair.child);
					if (node.lChild==null) {
						node.lChild = child;
					}else {
						node.rChild = child;
					}
					queue.clear();
					return root;
				}else {
					if (node.lChild!=null) {
						queue.offer(node.lChild);
					}
					if (node.rChild!=null) {
						queue.offer(node.rChild);
					}
				}
				queue.poll();
			}
		}
		return null;
	}
	
	public void display(TreeNode node){
		if (node!=null) {
			display(node.lChild);
			System.out.println(node.code);
			display(node.rChild);
		}
	}
	
	public int getHigh(TreeNode node){
		if (node == null) {
			return 0;
		}
		
		int lHigh = 0;
		int rHigh = 0;
		
		if (node.lChild != null) {
			lHigh = getHigh(node.lChild);
		}
		
		if (node.rChild != null) {
			rHigh = getHigh(node.rChild);
		}
		
		return (lHigh>rHigh) ? lHigh+1:rHigh+1;
	}
}
