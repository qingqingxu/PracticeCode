package saima.jinritoutiao.tireserializable;

public class Test implements Comparable<Test>{
	private String value;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test = new Test("123");
		try {
			Test test2 = (Test) test.clone();
			System.out.println(test==test2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public String toString() {
		return value;
	}


	public Test(String value) {
		this.value = value;
	}


	@Override
	public int compareTo(Test o) {
		// TODO Auto-generated method stub
		return Integer.parseInt(o.toString())-Integer.parseInt(value);
	}

}

