package com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 字符串转数字
 * 
 * @author XuQingQing
 *
 */
public class SerializableUN implements Serializable {

	private static final long serialVersionUID = 1L;
	// int a = 1;
	int i;

	public SerializableUN(int i) {
		this.i = i;
	}

	public void Test() {
		System.out.println("Test");
	}

	private static double noisyCount(double x, double u, double b) {
		return 0.5 * (1 + Math.signum(x - u) * (1 - Math.pow(Math.E, -Math.abs(x - u) / b)));
	}

	static void pong() {

		System.out.print("pong");

	}

	public static void main(String[] args) {
		ArrayList<SerializableUN> tests = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			tests.add(new SerializableUN(2));
		}
		System.out.println(tests);
		tests.clear();
		//序列化与反序列化
		/*Test test = new Test(9);
		//ObjectOutputStream out = new ObjectOutputStream();
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("temp"));
			out.writeObject(test);
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("temp"));
			try {
				Test test2 = (Test) in.readObject();
				System.out.println("test2: " + test.i);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*Thread t = new Thread() {

			public void run() {

				pong();
			}
		};

		t.run();

		System.out.print("ping");*/
		/*
		 * switch (10L) { case 1: System.out.println("1"); break;
		 * 
		 * default: break; }
		 */
		/*
		 * Test test = new Test(1); Test test2 = new Test(2); Test test3 = new
		 * Test(3); Set<Test> tests = new HashSet<>(); tests.add(test);
		 * tests.add(test2); tests.add(test3);
		 * 
		 * test2.i = 10; tests.remove(test2); for (Test test4 : tests) {
		 * System.out.println(test4.i); } System.out.println(tests.size());
		 */
		/*
		 * Test test = new Test(); test.Test();
		 */
		// System.out.println(Math.signum());

		/*
		 * Calendar calendar = Calendar.getInstance();
		 * calendar.set(Calendar.YEAR, 2016); calendar.set(Calendar.MONTH, 8);
		 * calendar.set(Calendar.DAY_OF_MONTH, 3);
		 * System.out.println(((int)(Calendar.getInstance().getTime().getTime()/
		 * 1000)-(int)(calendar.getTime().getTime()/1000))/3600/24);
		 */
		// Test test = new Test();
		// test.test();
		// System.out.println(-test.a);
		int a = 6, b = 5, c = 7, d = 8;
		// System.out.println((-a, b>a--&&c>d)?d++:a>b);
		// System.out.println(Runtime.getRuntime().availableProcessors());
		// System.out.println("ac".contains("c"));
		/*
		 * StringBuffer buffer = new StringBuffer(); buffer.append(2);
		 * buffer.append('3'); System.out.println(buffer.toString());
		 */
		/*
		 * Map<Integer, String> map = new TreeMap<>(); map.put(100, "ww");
		 * map.put(40, "hh"); map.put(110, "ff"); for (Integer integer :
		 * map.keySet()) { System.out.println(integer); }
		 */

		// TODO Auto-generated method stub
		// System.out.println(2147483647*10);
		// System.out.println(myAtoi(" 10522545459"));
		/*
		 * System.out.println(Integer.MAX_VALUE);
		 * System.out.println(Long.MAX_VALUE);
		 */
	}

	// void test(){
	// a = 2;
	// a += 1;
	// }

	public static int myAtoi(String str) {
		boolean isPositive = true;
		boolean isFirstNotEmptyChar = false;
		long result = 0;
		long tmp = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ' && !isFirstNotEmptyChar) {
				continue;
			} else if (!isFirstNotEmptyChar) {
				isFirstNotEmptyChar = true;
				if (str.charAt(i) == '-') {
					isPositive = false;
					continue;
				} else if (str.charAt(i) == '+') {
					continue;
				} else if (str.charAt(i) < '0' || str.charAt(i) > '9') {
					return 0;
				}
			}

			if (isFirstNotEmptyChar && (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
				tmp = result * 10 + Integer.parseInt(str.charAt(i) + "");
				// System.out.println(tmp+" "+result);
				if (tmp > Integer.MAX_VALUE) {
					return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				} else {
					result = tmp;
				}
			} else if (isFirstNotEmptyChar) {
				return (int) (isPositive ? result : -result);
			}

		}
		return (int) (isPositive ? result : -result);
	}
}
