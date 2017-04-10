package java.basic.annotation;

@Description("i am a class annotation")
public class Child implements Parent {

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Description("i am a method annotation")
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub

	}

}
