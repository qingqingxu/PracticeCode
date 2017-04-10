package bigfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultRead {

//	static CountDownLatch latch;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService cachedThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		String[] urls = {"E:/ST/RData/HPID/data/HPID/HPID/cz_lh_201310_01_of_15.txt",
				"E:/ST/RData/HPID/data/HPID/HPID/cz_lh_201310_02_of_15.txt",
				"E:/ST/RData/HPID/data/HPID/HPID/cz_lh_201310_03_of_15.txt",
				"E:/ST/RData/HPID/data/HPID/HPID/cz_lh_201310_04_of_15.txt",
				"E:/ST/RData/HPID/data/HPID/HPID/cz_lh_201310_05_of_15.txt"
		};
//		latch = new CountDownLatch(urls.length);
		long startTime = System.currentTimeMillis();
		for (String url : urls) {
			cachedThreadPool.execute(new MultRead().new ReadThread(url));
		}
		//注意，放入 CachedThreadPool 的线程不必担心其结束，超过 TIMEOUT 不活动，其会自动被终止
		cachedThreadPool.shutdown();
		while (!cachedThreadPool.isTerminated()) {
		}
//		try {
//			latch.await();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("use time: " + (System.currentTimeMillis() - startTime));
		
	}

	class ReadThread implements Runnable {

		private String fileUrl;

		public ReadThread(String fileUrl) {
			this.fileUrl = fileUrl;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			long num = 0;
			BufferedReader reader = null;
			try {
				String line = null;
				reader = new BufferedReader(new FileReader(fileUrl));
				while ((line = reader.readLine()) != null) {
					num++;
				}
				reader.close();
//				latch.countDown();
				System.out.println(fileUrl.substring(fileUrl.length() - fileUrl.lastIndexOf('/'), fileUrl.length())
						+ " num: " + num);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		}

	}

}
