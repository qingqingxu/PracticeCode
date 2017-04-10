package bigfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SignalRead {

	public static void main(String[] args) throws IOException {
		String line = null;
		long num = 0;
		long startTime = System.currentTimeMillis();
		String[] urls = {"E:/ST/RData/HPID/data/HPID/HPID/cz_lh_201310_01_of_15.txt",
				"E:/ST/RData/HPID/data/HPID/HPID/cz_lh_201310_02_of_15.txt",
				"E:/ST/RData/HPID/data/HPID/HPID/cz_lh_201310_03_of_15.txt",
				"E:/ST/RData/HPID/data/HPID/HPID/cz_lh_201310_04_of_15.txt",
				"E:/ST/RData/HPID/data/HPID/HPID/cz_lh_201310_05_of_15.txt"
		};
		for (String url : urls) {
			BufferedReader reader = new BufferedReader(new FileReader(url));
			while ((line = reader.readLine()) != null) {
				num++;
			}
			reader.close();
		}
		System.out.println("use time: "+(System.currentTimeMillis()-startTime));
		System.out.println("all line: "+num);
	}

}
