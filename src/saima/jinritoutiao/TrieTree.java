package saima.jinritoutiao;

import java.util.LinkedList;

public class TrieTree {

	public static void main(String[] args) {
		TrieTree trie = new TrieTree();  
        trie.insert("zengxiao");  
        trie.insert("zengxiaoqiang");  
        trie.insert("haohaoxuexi");  
        System.out.println(trie.search("zengxiao"));  
        System.out.println(trie.search("zeng"));  
        trie.delete("zengxiao");  
        System.out.println(trie.search("zengxiao"));
	}
	
	private TrieNode root;
	public TrieTree(){
		root = new TrieNode(' ');
	}
	
	public void insert(String word){
		if (search(word)) {
			return;
		}
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			TrieNode child = current.subNode(word.charAt(i));
			if (child!=null) {
				current = child;
			}else {
				current.childList.add(new TrieNode(word.charAt(i)));
				current = current.subNode(word.charAt(i));
			}
			current.count++;
		}
		current.isEnd = true;
	}
	
	public boolean search(String word){
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			if (current.subNode(word.charAt(i))==null) {
				return false;
			}else {
				current = current.subNode(word.charAt(i));
			}
		}
		if (current.isEnd) {
			return true;
		}
		return false;
	}
	
	public void delete(String word){
		if (!search(word)) {
			return;
		}
		
		TrieNode current = root;
		for (char c : word.toCharArray()) {
			TrieNode child = current.subNode(c);
			if (child.count == 1) {
				current.childList.remove(child);
				return;
			}else {
				child.count--;
				current = child;
			}
		}
		current.isEnd = false;
	}
}

class TrieNode{
	char content;
	boolean isEnd;
	int count;
	LinkedList<TrieNode> childList;
	TrieNode(char c) {
		childList = new LinkedList<>();
		isEnd = false;
		content = c;
		count = 0;
	}
	
	public TrieNode subNode(char c){
		if (childList!=null) {
			for (TrieNode trieNode : childList) {
				if (trieNode.content==c) {
					return trieNode;
				}
			}
		}
		return null;
	}
	
	
}
