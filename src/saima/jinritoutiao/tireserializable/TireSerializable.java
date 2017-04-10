package saima.jinritoutiao.tireserializable;

import java.util.LinkedList;
import java.util.Scanner;

public class TireSerializable{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			TireSerializable trie = new TireSerializable();
			for (int i = 1; i <= n; i++) {
				
			}
		}
	}
	
	private TrieNode root;
	public TireSerializable(){
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
				current.child.add(new TrieNode(word.charAt(i)));
				current = current.subNode(word.charAt(i));
			}
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
	
}

class TrieNode{
	LinkedList<TrieNode> child;
	int digit;
	boolean isEnd;
	
	public TrieNode(int digit) {
		this.digit = digit;
		child = new LinkedList<>();
		isEnd = false;
	}
	
	public TrieNode subNode(int digit){
		if (child!=null) {
			for (TrieNode trieNode : child) {
				if (trieNode.digit==digit) {
					return trieNode;
				}
			}
		}
		return null;
	}
}
