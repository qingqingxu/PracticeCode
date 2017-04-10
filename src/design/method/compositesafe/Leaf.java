package design.method.compositesafe;

public class Leaf implements Component {

	private String name;
	
	public Leaf(String name) {
		this.name = name;
	}

	@Override
	public void printStruct(String preStr) {
		// TODO Auto-generated method stub
		System.out.println(preStr + "-" + name);
	}

}
