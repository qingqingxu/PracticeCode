package nowcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharCollect {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			List<Character> array = new ArrayList<>();
			for (int i = 0; i < str.length(); i++) {
				if (!array.contains(str.charAt(i))) {
					array.add(str.charAt(i));
					System.out.print(str.charAt(i));
				}
			}
			System.out.println();
		}
	}

}
