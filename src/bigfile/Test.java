package bigfile;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test implements Runnable{

	static long count = 0;
	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
//		ExecutorService executorService = Executors.newCachedThreadPool();
//		for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
//			executorService.execute(new Test());
//		}
//		executorService.shutdown();
//		while (!executorService.isTerminated()) {
//		}
		
		while (count<1000000000) {
			count++;
		}
		System.out.println(System.currentTimeMillis() - start);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (count<1000000000) {
			count++;
		}
	}
	
	

}
