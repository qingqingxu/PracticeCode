package nowcode.interview.test;

import java.util.ArrayList;

public class SetOfStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> arrays = new ArrayList<>();
		ArrayList<Integer> array = new ArrayList<>();
		array.add(1);
		array.add(2);
		arrays.add(array);
		array = arrays.get(0);
		array.remove(1);
		array.add(3);
		for (Integer integer : arrays.get(0)) {
			System.out.println(integer);
		}
	}
	
	public static ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        // write code here
		ArrayList<ArrayList<Integer>> arrays = new ArrayList<>();
		for (int i = 0; i < ope.length; i++) {
			if (ope[i][0]==1) {
				ArrayList<Integer> array = null;
				if (arrays.size()==0||arrays.get(arrays.size()-1).size()==size) {
					array = new ArrayList<>();
					arrays.add(array);
				}else {
					array = arrays.get(arrays.size()-1);
				}
				array.add(ope[i][1]);
			}else if (ope[i][0]==2) {
				if (arrays.size()==0) {
					return null;
				}else if (arrays.get(arrays.size()-1).size()==1) {
					arrays.remove(arrays.size()-1);
				}else {
					ArrayList<Integer> array = arrays.get(arrays.size()-1);
					array.remove(array.size()-1);
				}
			}
			
		}
		return arrays;
    }

}
