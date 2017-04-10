package saima.jinritoutiao;

import java.util.Scanner;

public class StringShifting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String string = sc.nextLine();
			for (int i = 0; i < string.length(); i++) {
				String sub = string.substring(0, i+1);
				if (string.split(sub).length==0) {
					System.out.println(sub.length());
					break;
				}
			}
		}

	}

}
