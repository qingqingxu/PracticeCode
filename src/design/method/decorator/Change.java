package design.method.decorator;

public class Change implements TheGreatestSage {

	private TheGreatestSage sage;
	
	public Change(TheGreatestSage sage) {
		this.sage = sage;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		sage.move();
	}

}
