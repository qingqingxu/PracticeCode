package offer;

public class UglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] uglys = new int[1501];
		getUgly(uglys);
		
		for (int i = 0; i < 20; i++) {
			System.out.print(uglys[i] + "\t");
		}
	}
	
	public static void getUgly(int[] uglys){
		uglys[0] = 1;
		int loc2Time = 0, num2;
		int loc3Time = 0, num3;
		int loc5Time = 0, num5;
		
		int nextUglyLoc = 1;
		
		while (nextUglyLoc < 1501) {
			num2 = uglys[loc2Time] * 2;
			num3 = uglys[loc3Time] * 3;
			num5 = uglys[loc5Time] * 5;
			int min = getMin(num2, num3, num5);
			uglys[nextUglyLoc] = min;
			
			while (uglys[loc2Time] * 2 <= uglys[nextUglyLoc]) {
				loc2Time++;
			}
			while (uglys[loc3Time] * 3 <= uglys[nextUglyLoc]) {
				loc3Time++;
			}
			while (uglys[loc5Time] * 5 <= uglys[nextUglyLoc]) {
				loc5Time++;
			}
			
			nextUglyLoc++;
		}
	}
	
	public static int getMin(int num1, int num2, int num3){
		int min = (num1 < num2) ? num1 : num2;
		return (min < num3) ? min : num3;
	}

}
