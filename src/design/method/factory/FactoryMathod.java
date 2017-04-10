package design.method.factory;

public class FactoryMathod {

	public Sender produce(String type){
		switch (type) {
		case "SMS":
			return new SMS();
		case "Email":
			return new Email();
		default:
			return null;
		}
	}
	
	public static Sender produceSMS(){
		return new SMS();
	}
	
	public static Sender produceEmail(){
		return new Email();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*FactoryMathod mathod = new FactoryMathod();
		//Sender sender = mathod.produce("SMS");
		Sender sender = mathod.produceSMS();
		sender.send();*/
		Sender sender = produceEmail();
		sender.send();
	}

}
