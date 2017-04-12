package design.method.decorator;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TheGreatestSage sage = new Monkey();
        // 第一种写法
        TheGreatestSage bird = new Bird(sage);
        TheGreatestSage fish = new Fish(bird);
        // 第二种写法
        //TheGreatestSage fish = new Fish(new Bird(sage));
        fish.move();
	}

}
