package nowcode;

import java.util.Scanner;

public class LastWordLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			System.out.println(str.trim().substring(str.trim().lastIndexOf(' ')+1).length());
		}
	}

}
