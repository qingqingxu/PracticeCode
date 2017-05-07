package saima.xiecheng;

import java.util.Scanner;
import java.util.regex.Pattern;

public class GetResult {

	public static void main(String[] args) {
		Pattern p=Pattern.compile(",|\\[|\\]| "); 
		
		String[] strs = "[[1, -2, 2], [1, -1, 0],[-1, 1, 1]]".replace(" ", "").split("],");
		int m = strs.length;
		double[][] arrays = new double[m][];
		for (int i = 0; i < strs.length; i++) {
			String[] strings = p.split(strs[i]);
			int col = 0;
			for (String string : strings) {
				if (string!=null && !string.isEmpty()) {
					
					System.out.println(string);
					arrays[i][col++] = Double.valueOf(string);
				}
			}
			
			
		}

		/*Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			
		}*/
	}

}
