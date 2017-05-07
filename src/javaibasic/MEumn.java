package javaibasic;

public class MEumn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Season s : Season.values()) {
			System.out.println(s.name() + "\t" + s.ordinal());
		}
	}

}

enum Season{
	SPRING,
	SUMMER,
	FALL,
	WINTER
}
