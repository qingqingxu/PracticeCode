package design.method.factory;

public class SMS implements Sender {

	@Override
	public void send() {
		System.out.println("SMS");
		
	}

}
