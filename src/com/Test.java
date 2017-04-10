package com;

import java.util.Map;
import java.util.TreeMap;

/**
 * 字符串转数字
 * @author XuQingQing
 *
 */
public class Test {

//	int a = 1;
	public static void main(String[] args) {
//		Test test = new Test();
//		test.test();
//		System.out.println(-test.a);
		int a=6,b=5,c=7,d=8;
//		System.out.println((-a, b>a--&&c>d)?d++:a>b);
//		System.out.println(Runtime.getRuntime().availableProcessors());
//		System.out.println("ac".contains("c"));
		/*StringBuffer buffer = new StringBuffer();
		buffer.append(2);
		buffer.append('3');
		System.out.println(buffer.toString());*/
		/*Map<Integer, String> map = new TreeMap<>();
		map.put(100, "ww");
		map.put(40, "hh");
		map.put(110, "ff");
		for (Integer integer : map.keySet()) {
			System.out.println(integer);
		}*/
		
		// TODO Auto-generated method stub
		//System.out.println(2147483647*10);
		//System.out.println(myAtoi("    10522545459"));
		/*System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);*/
	}
	
//	void test(){
//		a = 2;
//		a += 1;
//	}

	public static int myAtoi(String str) {
		boolean isPositive = true;
		boolean isFirstNotEmptyChar = false;
		long result = 0;
		long tmp = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i)==' '&&!isFirstNotEmptyChar) {
				continue;
			}else if (!isFirstNotEmptyChar) {
				isFirstNotEmptyChar = true;
				if (str.charAt(i)=='-') {
					isPositive = false;
					continue;
				}else if (str.charAt(i)=='+') {
					continue;
				} else if (str.charAt(i)<'0'||str.charAt(i)>'9') {
					return 0;
				}
			}
			
			if (isFirstNotEmptyChar&&(str.charAt(i)>='0'&&str.charAt(i)<='9')) {
				tmp = result*10+Integer.parseInt(str.charAt(i)+"");
				//System.out.println(tmp+"    "+result);
				if(tmp>Integer.MAX_VALUE){
					return isPositive?Integer.MAX_VALUE:Integer.MIN_VALUE;
				}else {
					result = tmp;
				}
			}else if(isFirstNotEmptyChar){
				return (int)(isPositive?result:-result);
			}
			
		}
		return (int)(isPositive?result:-result);
	}
}
