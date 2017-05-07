package javaibasic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IHead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		HeadNode root = HeadNode.createHead(array);
		root.display(root);
	}

}

class HeadNode{
	int val;
	HeadNode lnode;
	HeadNode rnode;
	public HeadNode(int val) {
		// TODO Auto-generated constructor stub
		this.val = val;
	}
	
	public HeadNode maxHead(HeadNode root){
		Stack<HeadNode> stack = new Stack<>();
		Queue<HeadNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			HeadNode node = queue.peek();
			if (node.lnode!=null) {
				queue.offer(node.lnode);
			}
			if (node.rnode!=null) {
				queue.offer(node.rnode);
			}
			if (node.lnode!=null && node.rnode!=null) {
				stack.push(node);
			}
			queue.poll();
		}
		while (!stack.isEmpty()) {
			HeadNode node = stack.peek();
			/*while (node.val<node.lnode.val||node.val<node.rnode.val) {
				if (node.lnode.val>node.rnode.val) {
					int val = node.lnode.val;
					node.lnode.val = node.val;
					node.val = node.lnode.val;
					node = node.lnode;
				}else {
					int val = node.rnode.val;
					node.rnode.val = node.val;
					node.val = node.rnode.val;
					node = node.rnode;
				}
			}*/
		}
		return root;
	}
	
	public static HeadNode createHead(int[] array){
		HeadNode root = new HeadNode(array[0]);
		Queue<HeadNode> queue = new LinkedList<>();
		queue.offer(root);
		HeadNode node = null;queue.peek();
		for (int i = 0; i < array.length/2; i++) {
			node = queue.peek();
			node.lnode = new HeadNode(array[i*2+1]);
			queue.offer(node.lnode);
			if (i*2+2<array.length) {
				node.rnode = new HeadNode(array[i*2+2]);
				queue.offer(node.rnode);
			}
			queue.poll();
			
		}
		queue.clear();
		return root;
	}
	
	public void display(HeadNode node){
		if (node!=null) {
			System.out.println(node.val);
			display(node.lnode);
			
			display(node.rnode);
		}
	}
}
