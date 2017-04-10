package design.method.factoryabstrac;

public class SMSFactory implements Provider {

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new SMS();
	}

}
