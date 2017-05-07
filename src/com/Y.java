package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Y {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String source = "C:\\Users\\XuQingQing\\Desktop\\dblp.small.raw.txt";
		String splitByWord = "C:\\Users\\XuQingQing\\Desktop\\splitByWord.txt";
		String statisticsByWordPerRecord = "C:\\Users\\XuQingQing\\Desktop\\statisticsByWordPerRecord.txt";
		splitByWord(source, splitByWord);
		//statisticsByWordPerRecord(splitByWord, statisticsByWordPerRecord);
		System.out.println("over");
	}
	
	private static void statisticsByWordPerRecord(String in, String out){
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(in));
			String line = null;
			writer = new BufferedWriter(new FileWriter(out));
			while ((line = reader.readLine())!=null) {
				String[] strs = line.split(",");
				writer.write(strs[0]);
				TreeMap<String, Integer> map = new TreeMap<>();
				for (int i = 1; i < strs.length; i++) {
					Object object = map.get(strs[i]);
					if (object==null) {
						map.put(strs[i], 1);
					}else {
						map.put(strs[i], (int)object+1);
					}
				}
				for (Map.Entry<String, Integer> entry : map.entrySet()) {
					writer.write(","+ entry.getKey()+" "+entry.getValue());
				}
				writer.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					writer = null;
				}
			}
			if (reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					reader = null;
				}
				
			}
			
		}
	}
	
	private static void splitByWord(String in, String out){
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(in));
			String line = null;
			writer = new BufferedWriter(new FileWriter(out));
			int lineNum = 0;
			while ((line = reader.readLine())!=null) {
				lineNum++;
				writer.write(lineNum+"");
				//正则表达式写的不完全正确，如：C#本来就是一体，拆分后无意义，有的又要以#进行拆分
				String[] strs = line.split("/|、|，|。|;|？|！|,|\\.|:|\\?|!| |#|-|\\]|\\[|\\)|\\(|\\}|\\{|\\*");
				for (String string : strs) {
					if (string==null||string.equals(" ")||string.isEmpty()) {
						continue;
					}
					writer.write(","+string);
				}
				writer.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					writer = null;
				}
			}
			if (reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					reader = null;
				}
				
			}
			
		}
	}

}
