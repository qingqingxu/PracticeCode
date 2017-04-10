package design.method.builder;

import java.util.ArrayList;
import java.util.List;

public class Builder {
	private List<Sender> list = new ArrayList<>();
	public void produceSMS(int count){
		for (int i = 0; i < count; i++) {
			list.add(new SMS());
		}
	}
	
	public void produceEmail(int count){
		for (int i = 0; i < count; i++) {
			list.add(new Email());
		}
	}
	
	public static void main(String[] args) {
		Builder builder = new Builder();
		builder.produceEmail(3);
	}
}
