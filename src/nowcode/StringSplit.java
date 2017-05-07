package nowcode;

import java.util.Scanner;

public class StringSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			for (int i = 0; i < 2; i++) {
				String str = sc.nextLine();
				int j;
				for (j = 8; j <= str.length(); j=j+8) {
					System.out.println(str.substring(j-8, j));
				}
				j = str.length()/8*8;
				if (str.length()%8!=0) {
					System.out.print(str.substring(j));
					j = str.length();
					while(j%8!=0){
						System.out.print("0");
						j++;
					}
					System.out.println();
				}
				
				
			}
		}
	}

}
