package bigfile;


/**
 * 效率不好，还没有单文件直接处理快，也不知道问题到底出在哪 ？？？
 * @author XuQingQing
 *
 */
public class Main {

	public static void main(String[] args) {
		BigFileReader.Builder builder = new BigFileReader.Builder("E:/ST/RData/HPID/data/SIMCZ201301/SIMCZ.DAT",new IHandle() {
			
			@Override
			public void handle(String line) {
				//System.out.println(line);
				//increat();
			}
		});
		builder.withTreahdSize(Runtime.getRuntime().availableProcessors())
			   .withCharset("utf-8")
			   .withBufferSize(1024*1024);
		BigFileReader bigFileReader = builder.build();
		bigFileReader.start();
	}
	
}
