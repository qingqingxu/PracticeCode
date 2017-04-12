package saima.xiaomi;

import java.util.Scanner;

public class StateConvert {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			StringBuffer sb = new StringBuffer(sc.nextLine());
			sb.reverse();
			int start = 0;
			int end = 0;
			int i = 0;
			while(i<sb.length()){
				if (sb.charAt(i)!=' ') {
					start = i;
					while(i<sb.length()&&sb.charAt(i)!=' '){
						i++;
					}
					end = i-1;
					while(start<end){
						char tmp = sb.charAt(start);
						sb.setCharAt(start, sb.charAt(end));
						sb.setCharAt(end, tmp);
						start++;
						end--;
					}
				}
				i++;
			}
			System.out.println(sb.toString());
			
		}
	}

}
