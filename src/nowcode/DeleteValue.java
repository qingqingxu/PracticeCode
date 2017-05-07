package nowcode;

import java.util.Scanner;

public class DeleteValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			n = n > 1000 ? 1000 : n;
			int[] array = new int[n];
			if (n==0) {
				System.out.println(0);
				continue;
			}
			DoubleLinkedNode front = new DoubleLinkedNode(0);
			DoubleLinkedNode tmp = front;
			DoubleLinkedNode node = null;
			for (int i = 1; i < array.length; i++) {
				node = new DoubleLinkedNode(i);
				tmp.next = node;
				node.prevent = tmp;
				tmp = node;
			}
			node.next = front;
			front.prevent = node;
			//front.display(front);
			front.deleteValue(front);
		}
	}
}

class DoubleLinkedNode{
	int value;
	DoubleLinkedNode prevent;
	DoubleLinkedNode next;
	public DoubleLinkedNode(int value) {
		this.value = value;
		this.prevent = null;
		this.next = null;
	}
	
	public void deleteValue(DoubleLinkedNode front){
		DoubleLinkedNode pre;
		while(true){
			front = front.next;
			front = front.next;
			if (front.next != front) {
				pre = front.prevent;
				pre .next = front.next;
				front.next.prevent = pre;
				//System.out.println(front.value);
				front = pre.next;
			}else {
				break;
			}
		}
		System.out.println(front.value);
	}
	
	public void display(DoubleLinkedNode front){
		DoubleLinkedNode node = front;
		while(node.next!= front){
			System.out.println(node.value);
			node = node.next;
		}
		System.out.println(node.value);
	}
	
}