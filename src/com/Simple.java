package com;

import java.util.ArrayList;
import java.util.List;

public class Simple {

	
	public String str="6";
    public static void main(String[] args) {
    	Simple sv=new Simple();
        sv.change(sv.str);
        System.out.println(sv.str);
        sv.setStr("11");
        System.out.println(sv.getStr());
    }
    public void change(String str) {
        str="10";
    }
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
    
}
//	public static void main(String[] args) {
//		
////		Dog dog = new Dog('a');
////		dog.print();
////		
////		List list = new ArrayList<>();
////		list.add("a");
////		list.add("b");
////		list.add("c");
//		
//		
////		String a = "123";
////		switch ("123") {
////		case "123":
////			
////			break;
////
////		default:
////			break;
////		}
////		System.gc();
//	}
//
//}

class Dog {
	private int age;
	private String name;
	private char sex;
	
	public Dog() {
	}
	
	public Dog(int age) {
		this.age = age;
	}
	
	public Dog(String name) {
		this.name = name;
	}
	public Dog(int age, String name) {
		this(age);
//		this(name);
	}

	public void print(){
//		this(23);
		System.out.println(age);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
//		super.finalize();
		System.out.println("finalize");
	}
	
	// TODO Auto-generated constructor stub
}
