package datastructure.tree;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		Tree tree = new Tree();
		Node node = new Node(1);
		tree.root = node;
		
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		
		node.lChild = node2;
		node.rChild = node3;
		
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		
		node2.lChild = node4;
		node2.rChild = node5;
		
		tree.display(node);
		
		Map<String, Integer> map = new HashMap<>();
		map.put(null, null);
		for (String string : map.keySet()) {
			System.out.println(string);
			System.out.println(map.get(string));
		}
	}

}
