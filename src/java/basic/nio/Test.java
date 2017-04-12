package java.basic.nio;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path directory = Paths.get("D:/code/");
		//相对路径
		Path pathInDirectory = directory.resolve("Test/");
		
		//IO to NIO
		Path pathFromFile = new File("C:/").toPath();
		
		//NIO to IO
		File fileFromPath = Paths.get("C:/").toFile();
		
		//Files.deleteIfExists(directory);
	}

}
