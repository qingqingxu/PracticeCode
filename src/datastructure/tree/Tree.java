package datastructure.tree;

public class Tree {
	Node root;
	
	void display(Node node){
		if (node!=null) {
			display(node.lChild);
			System.out.println(node.data);
			display(node.rChild);
		}
	}
	
}
