package design.method.factoryabstrac;

public class EmailFactory implements Provider {

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new Email();
	}

}
