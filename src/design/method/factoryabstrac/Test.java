package design.method.factoryabstrac;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Provider provider = new SMSFactory();
		Sender sender = provider.produce();
		sender.send();
	}

}
