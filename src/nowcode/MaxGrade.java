package nowcode;

import java.util.Scanner;

public class MaxGrade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] array = new int[N];
			for (int i = 0; i < N; i++) {
				array[i] = sc.nextInt();
			}

			int a,b;
			for (int i = 0; i < M; i++) {
				String string = sc.next();
				a = sc.nextInt();
				b = sc.nextInt();
				
				switch (string.charAt(0)) {
				case 'Q':
					if (a>b) {
						a = a^b;
						b = a^b;
						a = a^b;
					}
					int max = array[a-1];
					for (int j = a; j < b; j++) {
						if (max < array[j]) {
							max = array[j];
						}
					}
					System.out.println(max);
					break;
				case 'U':
					array[a-1] = b;
					break;
				default:
					break;
				}
			}
		}
	}
	
}
