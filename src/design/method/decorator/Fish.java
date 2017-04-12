package design.method.decorator;

public class Fish extends Change {

	public Fish(TheGreatestSage sage) {
		super(sage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("Fish Move");
	}

}
