package design.method.prototypedetail;

public class ConcretePrototype2 implements Prototype {

	private String name;
	@Override
	public Prototype clone() {
		// TODO Auto-generated method stub
		ConcretePrototype2 prototype2 = new ConcretePrototype2();
		prototype2.setName(name);
		return prototype2;
	}
	

	@Override
	public String toString() {
		return "ConcretePrototype2 [name=" + name + "]";
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
