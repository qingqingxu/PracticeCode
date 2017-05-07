package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ReadN3 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("E:\\Group\\examples\\LUBM1U.n3"));
		String line = null;
		Set<String> set = new HashSet<>();
		while ((line = reader.readLine())!=null) {
			set.add(line);
		}
		reader.close();
		System.out.println(set.size());
		set.clear();
	}

}
