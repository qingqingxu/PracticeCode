package design.method.prototypedetail;

public class ConcretePrototype1 implements Prototype {

	private String name;
	
	@Override
	public Prototype clone() {
		// TODO Auto-generated method stub
		ConcretePrototype1 prototype1 = new ConcretePrototype1();
		prototype1.setName(name);
		return prototype1;
	}

	
	@Override
	public String toString() {
		return "ConcretePrototype1 [name=" + name + "]";
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

}
