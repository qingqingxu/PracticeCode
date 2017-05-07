package nowcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 数组越界等非法访问情况
 * 
E:\V1R2\product\dsfgsdfgfpgadrive.c 13257
E:\V1R2\product\fsdgsdgspgadrive.c 13255
E:\V1R2\product\fpsdggadrive.c 13255
E:\V1R2\product\fpgdfgdsfgdsgadrive.c 1325
E:\V1R2\product\fpgdfadrive.c 13255
E:\V1R2\product\fpgadrive.c 13254
E:\V1R2\product\fpgadrive.c 13253
E:\V1R2\product\fpgadrive.c 13252
E:\V1R2\product\fpgadrive.c 13251
E:\V1R2\product\fpgadrive.c 13253
E:\V1R2\product\fpgadrive.c 13254
E:\V1R2\product\fpgadrive.c 13253
E:\V1R2\product\fpgadrive.c 13252
E:\V1R2\product\fpgadrive.c 13251
E:\V1R2\product\fpgadrive.c 1325
 
 
 
 
 * @author XuQingQing
 *
 */
public class RecordError {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		LinkedHashMap<String, ErrorLog> map = new LinkedHashMap<>();
		String line = null;
		while ((line = sc.nextLine())!=null && !line.isEmpty()) {
			String key = line.substring(line.lastIndexOf('\\')+1);
			String[] values = key.split(" ");
			Object object = map.get(key);
			if (object==null) {
				map.put(key, new ErrorLog(values[0], values[1]));
			}else {
				((ErrorLog)object).addTimes();
			}
		}
		sc.close();
		List<ErrorLog> list = new ArrayList<>(map.values());
		Collections.sort(list);
		int count = 0;
		for (ErrorLog errorLog : list) {
			System.out.println(errorLog.toString());
			count++;
			if (count==8) {
				break;
			}
		}
		
	}
}

class ErrorLog implements Comparable<ErrorLog>{
	String fileName;
	String lineNum;
	int times;
	public ErrorLog(String fileName, String lineNum) {
		this.fileName = fileName;
		this.lineNum = lineNum;
		times = 1;
	}
	
	public void addTimes(){
		times++;
	}
	@Override
	public int compareTo(ErrorLog o) {
		// TODO Auto-generated method stub
		return o.times - times;
	}

	@Override
	public String toString() {
		if (fileName.length()>16) {
			return fileName.substring(fileName.length()-16) + " " + lineNum + " " + times;
		}
		return fileName + " " + lineNum + " " + times;
	}
}

