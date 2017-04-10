package offer;

public class BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode root = BinaryTreeNode.construct("12", "21");
		BinaryTreeNode.display(root);
	}

}

class BinaryTreeNode {
	protected BinaryTreeNode l_node;
	protected BinaryTreeNode r_node;
	protected char value;
	public BinaryTreeNode() {
	}
	
	public static BinaryTreeNode construct(String preString, String inString){
		if (!isHasSubTree(preString) || !isHasSubTree(inString)) {
			return null;
		}
		return constructCore(preString, inString);
	}
	
	public static BinaryTreeNode constructCore(String preString, String inString) {
		
		int length = preString.length();
		if (length != inString.length()) {
			throw new IllegalArgumentException("preString: " + preString + "  inString: " + inString);
		}
		char rootValue = preString.charAt(0);
		BinaryTreeNode rootNode = new BinaryTreeNode();
		rootNode.value = rootValue;
		rootNode.l_node = null;
		rootNode.r_node = null;
		
		int rootIndex = inString.indexOf(rootValue);
		if (rootIndex < 0) {
			throw new IllegalArgumentException(inString);
		}
		
		String leftSubInString = inString.substring(0, rootIndex);
		if (leftSubInString != null) {
			int leftSubTreeLength = leftSubInString.length();
			String leftSubPreString = preString.substring(1, leftSubTreeLength + 1);
			if (isHasSubTree(leftSubPreString)) {
				rootNode.l_node = constructCore(leftSubPreString, leftSubInString);
			}
		}
		
		String rightSubInString = inString.substring(rootIndex + 1, length);
		if (rightSubInString != null) {
			int rightSubTreeLength = rightSubInString.length();
			String rightSubPreString = preString.substring(length - rightSubTreeLength, length);
			if (isHasSubTree(rightSubPreString)) {
				rootNode.r_node = constructCore(rightSubPreString, rightSubInString);
			}
		}
		
		return rootNode;
	}
	
	public static void display(BinaryTreeNode root){
		if (root != null) {
			display(root.l_node);
			display(root.r_node);
			System.out.print(root.value);
		}
	}
	
	private static boolean isHasSubTree(String treeInfo){
		if (treeInfo == null || treeInfo.isEmpty()) {
			return false;
		}
		return true;
	}
	
}
