package java.basic.annotation;

public class Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Parent parent = new Child();
		parent.sing();
	}

}
