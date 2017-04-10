package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tmp {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\XuQingQing\\Desktop\\test.txt"));
		String lineStr = null;
		StringBuffer buffer = new StringBuffer();
		while ((lineStr = reader.readLine())!=null) {
			buffer.append(lineStr.replace(" ", "").replace("．", "。"));
		}
		reader.close();
		System.out.println(buffer.toString());
		//System.out.println(buffer.toString().length());
	}

}
