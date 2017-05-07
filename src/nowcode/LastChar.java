package nowcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class LastChar {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = reader.readLine())!=null){
			try {
				int n = Integer.valueOf(line);
				for (int i = 0; i < n; i++) {
					String str = reader.readLine();
					LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
					for (int j = 0; j < str.length(); j++) {
						Object object = map.get(str.charAt(j));
						if (object==null) {
							map.put(str.charAt(j), 1);
						}else {
							map.put(str.charAt(j), (int)object+1);
						}
					}
					for (Map.Entry<Character, Integer> entry : map.entrySet()) {
						if (entry.getValue()==1) {
							System.out.println(entry.getKey());
							map.clear();
							break;
						}
					}
				}
			} catch (NumberFormatException e) {
				// TODO: handle exception
				continue;
			}
			
			
		}
	}

}
