package saima.xiaomi;

import java.util.Stack;

public class GetSplitNode {

	public static void main(String[] args) {
		String[] matrix = {"0001","0001","0001","1110"};
		System.out.println(getSplitNode(matrix, 3, 2));
	}
	
	 public static int getSplitNode(String[] matrix, int indexA, int indexB) {
		 if (indexA==indexB) {
			return indexA;
		}
		 char[][] a = new char[matrix.length][];
		 int i = 0;
		 for (String string : matrix) {
			a[i++] = string.toCharArray(); 
		 }
		 boolean[] flags = new boolean[matrix.length];
		 Stack<Integer> stack = new Stack<>();
		 stack.push(0);
		 flags[0] = true;
		 while (!stack.isEmpty()) {
			int parent = stack.pop();
			for (int j = 0; j < a[parent].length; j++) {
				if (a[parent][j]=='1'&&!flags[j]) {
					stack.push(j);
					a[j][parent] = '0';
				}
			}
		 }
		 
		 /*for (int j = 0; j < a.length; j++) {
			for (int j2 = 0; j2 < a[j].length; j2++) {
				System.out.print(a[j][j2]);
			}
			System.out.println();
		 }*/
		 
		 boolean[] flag = new boolean[matrix.length];
		 flag[indexA] = true;
		 
		 for (int j = 0; j < a.length && indexA!=0; j++) {
			 //System.out.println(a[j][indexA]==1);
				if (a[j][indexA]=='1') {
					flag[j] = true;
					indexA = j;
					j=0;
					//System.out.println(indexA);
				}
			}
		 
		/* for (int j = 0; j < flag.length; j++) {
			System.out.println(j+"\t" + flag[j]);
		}*/
		 flag[indexB] = true;
		 for (int j = 0; j < a.length && indexB!=0; j++) {
				if (a[j][indexB]=='1') {
					if (flag[j]) {
						return j;
					}
					flag[j] = true;
					indexB = j;
					j=0;
				}
			}
			
		 return 0;
			
	 }
	
	

}
